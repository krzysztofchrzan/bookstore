fetchData(document.querySelector("table"));

async function fetchData(table) {
	try {
		const response = await fetch("http://localhost:3000/customer");
		const tableBody = table.querySelector("tbody");

		if (!response.ok) throw new Error("Could not fetch resource.");
		data = await response.json();
		for (const key in data) {
			//console.log("Trying to fetch data:");
			const rowElement = document.createElement("tr");

			const cellElement1 = document.createElement("td");
			cellElement1.textContent = data[key].id;
			rowElement.appendChild(cellElement1);

			const cellElement2 = document.createElement("td");
			cellElement2.textContent = data[key].name;
			rowElement.appendChild(cellElement2);

			const cellElement3 = document.createElement("td");
			cellElement3.textContent = data[key].surname;
			rowElement.appendChild(cellElement3);

			const cellElement4 = document.createElement("td");
			cellElement4.textContent = data[key].age;
			rowElement.appendChild(cellElement4);			

			
			tableBody.appendChild(rowElement);
		}
	//   if (data.hasOwnProperty(key))
	 //  {
		  // here you have access to
		//  var surname = data[key].surname;
		//  var name = data[key].name;
	  //}
		//console.log(data);
	}
	catch(error){ console.error(error); }
}