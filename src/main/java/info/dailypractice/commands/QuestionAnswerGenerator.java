package info.dailypractice.commands;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import info.dailypractice.entity.QuestionAnswerKural;
import info.dailypractice.entity.QuestionAnswerKuralConfiguration;
import info.dailypractice.entity.ThirukkuralAgaraMudhali;
import info.dailypractice.service.ThirukkuralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.File;
import java.io.IOException;
import java.util.List;

@ShellComponent
public class QuestionAnswerGenerator {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ThirukkuralService thirukkuralService;

    @ShellMethod("generate thirukkural Question Answer")
    public void generateThirukkuralQuestionAnswer(String dataFilepath) throws IOException, RuntimeException, TemplateException {

//      QuestionAnswerKuralConfiguration questionAnswerKuralConfiguration = objectMapper.readValue(new File(dataFilepath), QuestionAnswerKuralConfiguration.class);
        List<QuestionAnswerKuralConfiguration> questionAnswerKuralConfigurationList = objectMapper.readValue(new File(dataFilepath), new TypeReference<>() {
        });
        questionAnswerKuralConfigurationList.forEach(questionAnswerKuralConfiguration ->
                doProcess(questionAnswerKuralConfiguration));
    }

    private void doProcess(QuestionAnswerKuralConfiguration questionAnswerKuralConfiguration) {
        System.out.println("processing: " + questionAnswerKuralConfiguration);

        List<QuestionAnswerKural> questionAnswerKuralList = questionAnswerKuralConfiguration.getQuestionAnswerKuralList();

        questionAnswerKuralList.forEach(questionAnswerKural -> {
//            For each question, get list of answer kurals
            System.out.println(questionAnswerKural.getQuestion());
            List<ThirukkuralAgaraMudhali> answerThirukkuralDetails = thirukkuralService.getThirukkuralDetails(questionAnswerKuralConfiguration.getFirstKuralId(),
                    questionAnswerKuralConfiguration.getLastKuralId(),
                    questionAnswerKural.getAnswerKuralIds());
        });


    }
}
