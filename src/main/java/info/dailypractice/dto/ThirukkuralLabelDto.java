package info.dailypractice.dto;

import java.util.Objects;

public class ThirukkuralLabelDto {

    private int kural_id;
    private String line1;
    private String line2;
    private int group_id;
    private String name_ta;
    private String name_en;
    private String name_gu_pope;
    private String author_name_1;
    private String urai_1;

    public ThirukkuralLabelDto(int kural_id, String line1, String line2, int group_id, String name_ta, String name_en, String name_gu_pope, String author_name_1, String urai_1) {
        this.kural_id = kural_id;
        this.line1 = line1;
        this.line2 = line2;
        this.group_id = group_id;
        this.name_ta = name_ta;
        this.name_en = name_en;
        this.name_gu_pope = name_gu_pope;
        this.author_name_1 = author_name_1;
        this.urai_1 = urai_1;
    }

    public int getKural_id() {
        return kural_id;
    }

    public void setKural_id(int kural_id) {
        this.kural_id = kural_id;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getName_ta() {
        return name_ta;
    }

    public void setName_ta(String name_ta) {
        this.name_ta = name_ta;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getName_gu_pope() {
        return name_gu_pope;
    }

    public void setName_gu_pope(String name_gu_pope) {
        this.name_gu_pope = name_gu_pope;
    }

    public String getAuthor_name_1() {
        return author_name_1;
    }

    public void setAuthor_name_1(String author_name_1) {
        this.author_name_1 = author_name_1;
    }

    public String getUrai_1() {
        return urai_1;
    }

    public void setUrai_1(String urai_1) {
        this.urai_1 = urai_1;
    }

    @Override
    public String toString() {
        return "ThirukkuralLabelDto{" +
               "kural_id=" + kural_id +
               ", line1='" + line1 + '\'' +
               ", line2='" + line2 + '\'' +
               ", group_id=" + group_id +
               ", name_ta='" + name_ta + '\'' +
               ", name_en='" + name_en + '\'' +
               ", name_gu_pope='" + name_gu_pope + '\'' +
               ", author_name_1='" + author_name_1 + '\'' +
               ", urai_1='" + urai_1 + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThirukkuralLabelDto that = (ThirukkuralLabelDto) o;
        return kural_id == that.kural_id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(kural_id);
    }
}
