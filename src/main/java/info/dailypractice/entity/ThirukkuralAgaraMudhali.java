package info.dailypractice.entity;

import java.util.Objects;

public class ThirukkuralAgaraMudhali {
    private int id;
    private int kural_id;
    private String line1;
    private String cleaned_line1;
    private String line2;
    private int group_id;
    private String id_title_ta;
    private String id_title_en;
    private String tamil;
    private String english;

    public ThirukkuralAgaraMudhali(int id, int kural_id, String line1, String cleaned_line1, String line2, int group_id, String id_title_ta, String id_title_en, String tamil, String english) {
        this.id = id;
        this.kural_id = kural_id;
        this.line1 = line1;
        this.cleaned_line1 = cleaned_line1;
        this.line2 = line2;
        this.group_id = group_id;
        this.id_title_ta = id_title_ta;
        this.id_title_en = id_title_en;
        this.tamil = tamil;
        this.english = english;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCleaned_line1() {
        return cleaned_line1;
    }

    public void setCleaned_line1(String cleaned_line1) {
        this.cleaned_line1 = cleaned_line1;
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

    public String getId_title_ta() {
        return id_title_ta;
    }

    public void setId_title_ta(String id_title_ta) {
        this.id_title_ta = id_title_ta;
    }

    public String getId_title_en() {
        return id_title_en;
    }

    public void setId_title_en(String id_title_en) {
        this.id_title_en = id_title_en;
    }

    public String getTamil() {
        return tamil;
    }

    public void setTamil(String tamil) {
        this.tamil = tamil;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    @Override
    public String toString() {
        return "ThirukkuralAgaraMudhali{" +
               "id=" + id +
               ", kural_id=" + kural_id +
               ", line1='" + line1 + '\'' +
               ", cleaned_line1='" + cleaned_line1 + '\'' +
               ", line2='" + line2 + '\'' +
               ", group_id=" + group_id +
               ", id_title_ta='" + id_title_ta + '\'' +
               ", id_title_en='" + id_title_en + '\'' +
               ", tamil='" + tamil + '\'' +
               ", english='" + english + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThirukkuralAgaraMudhali that = (ThirukkuralAgaraMudhali) o;
        return kural_id == that.kural_id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(kural_id);
    }
}
