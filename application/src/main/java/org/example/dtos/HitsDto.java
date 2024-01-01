package org.example.dtos;

import lombok.*;

import java.util.List;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HitsDto {
    List<HitDto> hits;

//    public HitsDto(List<HitDto> hitDtos) {
//        this.hitDtos = hitDtos;
//    }
//
//    public HitsDto() {
//    }
//
//    public List<HitDto> getHits() {
//        return hitDtos;
//    }
//
//    public void setHits(List<HitDto> hitDtos) {
//        this.hitDtos = hitDtos;
//    }
//
//    @Override
//    public String toString() {
//        return "HitsDto{" +
//                "hitDtos=" + hitDtos +
//                '}';
//    }
}
