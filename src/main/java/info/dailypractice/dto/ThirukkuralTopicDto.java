package info.dailypractice.dto;

import java.util.Objects;

public class ThirukkuralTopicDto {
    private int group_id;
    private String name_ta;
    private String name_en;

    public ThirukkuralTopicDto(int group_id, String name_ta, String name_en) {
        this.group_id = group_id;
        this.name_ta = name_ta;
        this.name_en = name_en;
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

    @Override
    public String toString() {
        return "ThirukkuralTopicDto{" +
               "group_id=" + group_id +
               ", name_ta='" + name_ta + '\'' +
               ", name_en='" + name_en + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThirukkuralTopicDto that = (ThirukkuralTopicDto) o;
        return group_id == that.group_id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(group_id);
    }
}
