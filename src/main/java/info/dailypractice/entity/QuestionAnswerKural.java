package info.dailypractice.entity;

public class QuestionAnswerKural {
    private String question;
    private Integer[] answerKuralIds;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer[] getAnswerKuralIds() {
        return answerKuralIds;
    }

    public void setAnswerKuralIds(Integer[] answerKuralIds) {
        this.answerKuralIds = answerKuralIds;
    }
}
