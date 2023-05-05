package com.masai.service;

import java.util.Map;

import com.masai.entities.Buses;
import com.masai.exceptions.BusException;

public interface BusesService {
	public String addBus(Buses bus,Map<Integer,Buses> buses);
	public void ViewAllBusses(Map<Integer,Buses> buses)throws BusException;
	public void deleteBus(int id,Map<Integer,Buses> buses)throws BusException;
	public String updateBus(int id , Buses bus,Map<Integer,Buses> buses) throws BusException;
}