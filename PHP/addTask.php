<?php

public function addTask($description, $address, $latitude, $longitude) {
        	//$uuid = uniqid('', true);
 
	        $stmt = $this->conn->prepare("INSERT INTO tasksTBL(description, address, latitude, londitude) VALUES(?, ?, ?, ?)");
        	$stmt->bind_param('sss',/* $uuid,*/ $description, $address, $latitude, $longitude);
        	$result = $stmt->execute();
        	$stmt->close();
		 
	        // Check for successful store
        	if ($result) {
            		$stmt = $this->conn->prepare("SELECT * FROM tasksTBL WHERE description = ?");
            		$stmt->bind_param('s', $description;
            		$stmt->execute();
            		$user = $stmt->get_result()->fetch_assoc();
            		$stmt->close();
			return $description;
        	} else {
            		return false;
        	}
	}