package com.wendy.driverslicense.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wendy.driverslicense.models.License;
import com.wendy.driverslicense.repositories.LicenseRepository;

@Service
public class LicenseService {
	@Autowired
	public LicenseRepository lRepo;
	
	public License createLicense(License license) {
		license.setNumber(this.generateLicenseNumber());
		return this.lRepo.save(license);
	}
	
	public int generateLicenseNumber() {
		License l = this.lRepo.findTopByOrderByNumberDesc();
		if(l==null) {
			return 1;
		}
		int previousLicensetNumber = l.getNumber();
		previousLicensetNumber++;
		return(previousLicensetNumber);
	}
}
	