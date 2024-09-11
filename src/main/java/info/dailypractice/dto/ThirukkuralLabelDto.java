package info.dailypractice.dto;

import java.util.Objects;

public class ThirukkuralLabelDto {

    private int kural_id;
    private String line1;
    private String line2;
    private int group_id;
    private String name_ta;

    public ThirukkuralLabelDto(int kural_id, String line1, String line2, int group_id, String name_ta) {
        this.kural_id = kural_id;
        this.line1 = line1;
        this.line2 = line2;
        this.group_id = group_id;
        this.name_ta = name_ta;
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

    @Override
    public String toString() {
        return "ThirukkuralLabelDto{" +
                "kural_id=" + kural_id +
                ", line1='" + line1 + '\'' +
                ", line2='" + line2 + '\'' +
                ", group_id=" + group_id +
                ", name_ta='" + name_ta + '\'' +
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
