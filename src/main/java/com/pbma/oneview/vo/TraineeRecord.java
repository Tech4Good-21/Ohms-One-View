package com.pbma.oneview.vo;

public record TraineeRecord(Long id,
                            String name,
                            String gender,
                            String idType,
                            Integer idNumber,
                            String email,
                            String address,
                            String district,
                            Integer pin,
                            String state) {

}
