package com.cleartrip.properties.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.cleartrip.properties.model.Property;
import com.cleartrip.properties.model.User;

public class SearchPropertiesService {

	private UserRegisterService userRegisterService;

	public SearchPropertiesService(UserRegisterService userRegisterService) {
		super();
		this.userRegisterService = userRegisterService;
	}
	
	public List<Property> listPorp= new ArrayList<Property>();
	public Map<String, List<Property>> mapearchList= new HashMap<String, List<Property>>();
	

	public List<Property> searchProperties(String location, String priceRange, String type, String size, int numberOfRooms,
			String sortOn) {
		
		List<Property> totallistOfPropLoc=new ArrayList<Property>();
		for(Map.Entry<String, User> usersProperties :userRegisterService.userMap.entrySet()) {
			User user=usersProperties.getValue();
			List<Property> listOfProp=user.getListOfProperties();
			List<Property> listOfPropFilter=null;
			
			if(location!=null && priceRange !=null &&  type!=null && size !=null && numberOfRooms !=0 && sortOn!=null) {
				String range[]=priceRange.split("-");
				long p1=Integer.parseInt(range[0]);
				long p2=Integer.parseInt(range[1]);
				listOfPropFilter=listOfProp.stream().
						filter(p->p.getLocation().equals(location)).
						filter(p->p.getPrice()>=p1 && p.getPrice()<=p2 )
						.filter(p->p.getType().equalsIgnoreCase(type))
						.filter(p->p.getSize().equalsIgnoreCase(size))
						.filter(p-> p.getNumberOfRoom()==numberOfRooms).filter(p->p.getStatus().toString().equalsIgnoreCase("AVAILABLE"))
						.collect(Collectors.toList());
				
				if(sortOn.equalsIgnoreCase("price")) {
					listOfPropFilter=listOfPropFilter.stream().sorted((a,b)->a.getPrice()-b.getPrice()).collect(Collectors.toList());
				}else{
					listOfPropFilter=listOfPropFilter.stream().sorted((a,b)->a.getNumberOfRoom()-b.getNumberOfRoom()).collect(Collectors.toList());
				}
			}
			
			else if(priceRange !=null &&  type!=null && size !=null && numberOfRooms !=0 && sortOn!=null) {
				String range[]=priceRange.split("-");
				long p1=Integer.parseInt(range[0]);
				long p2=Integer.parseInt(range[1]);
				listOfPropFilter=listOfProp.stream().
						filter(p->p.getPrice()>=p1 && p.getPrice()<=p2 )
						.filter(p->p.getType().equalsIgnoreCase(type))
						.filter(p->p.getSize().equalsIgnoreCase(size))
						.filter(p-> p.getNumberOfRoom()==numberOfRooms).filter(p->p.getStatus().toString().equalsIgnoreCase("AVAILABLE"))
						.collect(Collectors.toList());
				
				if(sortOn.equalsIgnoreCase("price")) {
					listOfPropFilter=listOfPropFilter.stream().sorted((a,b)->a.getPrice()-b.getPrice()).collect(Collectors.toList());
				}else{
					listOfPropFilter=listOfPropFilter.stream().sorted((a,b)->a.getNumberOfRoom()-b.getNumberOfRoom()).collect(Collectors.toList());
				}
			}
			
			else if(type!=null && size !=null && numberOfRooms !=0 && sortOn!=null) {
				listOfPropFilter=listOfProp.stream()
						.filter(p->p.getType().equalsIgnoreCase(type))
						.filter(p->p.getSize().equalsIgnoreCase(size))
						.filter(p-> p.getNumberOfRoom()==numberOfRooms).filter(p->p.getStatus().toString().equalsIgnoreCase("AVAILABLE"))
						.collect(Collectors.toList());
				
				if(sortOn.equalsIgnoreCase("price")) {
					listOfPropFilter=listOfPropFilter.stream().sorted((a,b)->a.getPrice()-b.getPrice()).collect(Collectors.toList());
				}else{
					listOfPropFilter=listOfPropFilter.stream().sorted((a,b)->a.getNumberOfRoom()-b.getNumberOfRoom()).collect(Collectors.toList());
				}
			}
			else if( size !=null && numberOfRooms !=0 && sortOn!=null) {
				listOfPropFilter=listOfProp.stream()
						.filter(p->p.getSize().equalsIgnoreCase(size))
						.filter(p-> p.getNumberOfRoom()==numberOfRooms).filter(p->p.getStatus().toString().equalsIgnoreCase("AVAILABLE"))
						.collect(Collectors.toList());
				
				if(sortOn.equalsIgnoreCase("price")) {
					listOfPropFilter=listOfPropFilter.stream().sorted((a,b)->a.getPrice()-b.getPrice()).collect(Collectors.toList());
				}else{
					listOfPropFilter=listOfPropFilter.stream().sorted((a,b)->a.getNumberOfRoom()-b.getNumberOfRoom()).collect(Collectors.toList());
				}
			}
			else if(numberOfRooms !=0 && sortOn!=null) {
				listOfPropFilter=listOfProp.stream()
						.filter(p-> p.getNumberOfRoom()==numberOfRooms).filter(p->p.getStatus().toString().equalsIgnoreCase("AVAILABLE"))
						.collect(Collectors.toList());
				
				if(sortOn.equalsIgnoreCase("price")) {
					listOfPropFilter=listOfPropFilter.stream().sorted((a,b)->a.getPrice()-b.getPrice()).collect(Collectors.toList());
				}else{
					listOfPropFilter=listOfPropFilter.stream().sorted((a,b)->a.getNumberOfRoom()-b.getNumberOfRoom()).collect(Collectors.toList());
				}
			}
			else if( sortOn!=null) {
				if(sortOn.equalsIgnoreCase("price")) {
					listOfPropFilter=listOfProp.stream().sorted((a,b)->a.getPrice()-b.getPrice()).filter(p->p.getStatus().toString().equalsIgnoreCase("AVAILABLE")).collect(Collectors.toList());
				}else{
					listOfPropFilter=listOfProp.stream().sorted((a,b)->a.getNumberOfRoom()-b.getNumberOfRoom()).filter(p->p.getStatus().toString().equalsIgnoreCase("AVAILABLE")).collect(Collectors.toList());
				}
			}else {
				listOfPropFilter=listOfProp;
			}
			
			if(listOfPropFilter!=null) {
				mapearchList.put(user.getUser(), listOfPropFilter);
				totallistOfPropLoc.addAll(listOfPropFilter);
			}
		}
		listPorp=totallistOfPropLoc;
		return totallistOfPropLoc;
		
	}

}
