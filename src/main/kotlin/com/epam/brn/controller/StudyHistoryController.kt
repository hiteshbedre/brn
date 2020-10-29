package com.epam.brn.controller

import com.epam.brn.dto.BaseSingleObjectResponseDto
import com.epam.brn.dto.StudyHistoryDto
import com.epam.brn.service.StudyHistoryService
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/study-history")
@Api(value = "/study-history", description = "Contains actions over the results of finished exercise")
class StudyHistoryController(@Autowired val studyHistoryService: StudyHistoryService) {

    @PostMapping
    fun save(@Validated @RequestBody studyHistoryDto: StudyHistoryDto): ResponseEntity<StudyHistoryDto> {
        return ResponseEntity.ok().body(studyHistoryService.save(studyHistoryDto))
    }

    @GetMapping("/todayTimer")
    fun getTodayWorkDurationInSeconds(): ResponseEntity<BaseSingleObjectResponseDto> {
        return ResponseEntity.ok().body(BaseSingleObjectResponseDto(data = studyHistoryService.getTodayTimer()))
    }
}
