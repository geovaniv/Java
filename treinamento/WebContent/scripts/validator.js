function validatePeople() {
	let peopleFirstName = frmPeople.peopleFirstName.value
	let peopleLastName = frmPeople.peopleLastName.value
	
	if(peopleFirstName === ""){
		alert("O campo nome é obrigatório!")
		frmPeople.peopleFirstName.focus()
		return false
	} else if (peopleLastName === ""){
		alert("O campo sobrenome é obrigatório!")
		frmPeople.peopleLastName.focus()
		return false
	} else {
		document.forms["frmPeople"].submit()
	}
}

function validateRoom() {
	let roomName = frmRoom.roomName.value
	let roomCapacity = frmRoom.roomCapacity.value
	
	if(roomName === ""){
		alert("O campo nome é obrigatório!")
		frmRoom.roomName.focus()
		return false
	} else if (roomCapacity === ""){
		alert("O campo locatação é obrigatório!")
		frmRoom.roomCapacity.focus()
		return false
	} else {
		document.forms["frmRoom"].submit()
	}
}

function validateCoffee() {
	let coffeeName = frmCoffee.coffeeName.value
	
	if(coffeeName === ""){
		alert("O campo nome é obrigatório!")
		frmCoffee.coffeeName.focus()
		return false
	} else {
		document.forms["frmCoffee"].submit()
	}
}