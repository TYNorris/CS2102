class PHR {
  String name;
  double height;
  double weight;
  int heartRate;

  PHR(String name, double height, double weight, int heartRate) {
    this.name = name;
    this.height = height;
    this.weight = weight;
    this.heartRate = heartRate;
  }
  
  double getBMI(){
	if(height>=0)
	  return weight/(height*height);
	else
	 return -1;
  }
}
