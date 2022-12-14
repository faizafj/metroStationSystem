package com.emily.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class StationList {
    Collection<Station> stationList;
}
