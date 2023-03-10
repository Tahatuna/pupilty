package com.solana.pupilty.request.educaterRequest;

import com.solana.pupilty.enums.Category;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class CreateLessonRequest {

    private String lessonName;
    @Lob
    private String description;
    private String price;
    private Long educater_id;
    private Category category;

}

