package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.request.BuildingRequestDTO;
import com.laptrinhjavaweb.dto.response.BuildingResponseDTO;
import com.laptrinhjavaweb.dto.response.BuildingManagerResponseDTO;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {

    @Autowired
    private IBuildingService buildingService;

    @Autowired
    private IUserService userService;

    @PostMapping
    public ResponseEntity<BuildingResponseDTO> creatBuilding(@RequestBody BuildingRequestDTO dto){
        return ResponseEntity.ok(buildingService.save(-1, dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BuildingResponseDTO> updateBuilding(@PathVariable(value = "id",required = false) long id, @RequestBody BuildingRequestDTO dto) {
        return ResponseEntity.ok(buildingService.save(id, dto));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteBuilding(@RequestBody long[] buildingIds) {
        if(buildingIds.length > 0){
            buildingService.deleteBuilding(buildingIds);
        }
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("/{buildingId}/staffs")
    public ResponseEntity<List<BuildingManagerResponseDTO>> getStaffs(@PathVariable("buildingId") Long id){

        return ResponseEntity.ok(userService.findStaffByBuildingId(id));
    }

    @PostMapping("/{buildingId}/assignment")
    public ResponseEntity<Void> assignmentBuilding(@PathVariable("buildingId") Long id, @RequestBody List<Long> staffIds){
        buildingService.assignmentBuildingForStaffs(id,staffIds);
        return  ResponseEntity.noContent().build();
    }

}
