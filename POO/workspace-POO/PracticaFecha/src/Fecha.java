
public class Fecha
{
	
private int d,m,a;

	public Fecha(int dia, int mes, int año) {
		this.d=dia;
		this.m=mes;
		this.a=año;
		
		while(!this.comprobar(this.d,this.m,this.a))
		{
			System.out.println("FECHA ERRONEA.\nIntroduzca un nuevo dia: ");
			this.d = Teclado.leerInt();
			System.out.println("Introduzca un nuevo mes: ");
			this.m = Teclado.leerInt();
			System.out.println("Introduzca un nuevo año: ");
			this.a = Teclado.leerInt();
		}
	}

	public boolean comprobar(int dia, int mes, int año){
		boolean valido=false;
              
       if((año>0)&&(mes>0)&&(mes<=12))
       {
    	   switch(mes)
           {
                case 1: if((dia>0)&&(dia<=31))valido=true;
                break;

                case 2: if((dia>0)&&(dia<=28))valido=true;
                break;

                case 3: if((dia>0)&&(dia<=31))valido=true;
                break;

                case 4: if((dia>0)&&(dia<=30))valido=true;
                break;

                case 5: if((dia>0)&&(dia<=31))valido=true;
                break;

                case 6: if((dia>0)&&(dia<=30))valido=true;
                break;

                case 7: if((dia>0)&&(dia<=31))valido=true;
                break;

                case 8: if((dia>0)&&(dia<=31))valido=true;
                break;

                case 9: if((dia>0)&&(dia<=30))valido=true;
                break;

                case 10: if((dia>0)&&(dia<=31))valido=true;
                break;

                case 11: if((dia>0)&&(dia<=30))valido=true;
                break;

                case 12: if((dia>0)&&(dia<=31))valido=true;
                break;
            }
        }
		return valido;
	}
	
	
	
	
	
	  public void mostrarFormato(int formato)
	  {
         
          switch(formato)
          {
              case 1: System.out.println(this.d+"/"+this.m+"/"+this.a);
                  break;
              case 2: 
            	  switch(this.m)
            	  {
                      case 1: System.out.println(this.d+"/ENERO/"+this.a);
                          break;

                      case 2: System.out.println(this.d+"/FEBRERO/"+this.a);
                          break;

                      case 3: System.out.println(this.d+"/MARZO/"+this.a);
                          break;

                      case 4: System.out.println(this.d+"/ABRIL/"+this.a);
                          break;

                      case 5: System.out.println(this.d+"/MAYO/"+this.a);
                          break;

                      case 6: System.out.println(this.d+"/JUNIO/"+this.a);
                          break;

                      case 7: System.out.println(this.d+"/JULIO/"+this.a);
                          break;

                      case 8: System.out.println(this.d+"/AGOSTO/"+this.a);
                          break;

                      case 9: System.out.println(this.d+"/SEPTIEMBRE/"+this.a);
                          break;

                      case 10: System.out.println(this.d+"/OCTUBRE/"+this.a);
                          break;

                      case 11: System.out.println(this.d+"/NOVIEMBRE/"+this.a);
                          break;

                      case 12: System.out.println(this.d+"/DICIEMBRE/"+this.a);
                          break;
            	  }break;
          }
      }
	
	
	public int comparar(Fecha fecha2)
	{
        /*Devuelve:
         *  0 si la fecha2 es mayor que 1
         *  1 si la fecha1 y 2 son iguales
         *  2 si la fecha2 es menor que la 1
         */

        if(fecha2.a>this.a)
            return 0;
        else
        {
            if(fecha2.a<this.a)
                return 2;
            else
            {
                if(fecha2.m>this.m)
                    return 0;
                else
                {
                    if(fecha2.m<this.m)
                        return 2;
                    else
                    {
                        if(fecha2.d>this.d)
                            return 0;
                        else
                        {
                            if(fecha2.d<this.d)
                                return 2;
                            else
                                return 1;
                            
                        }
                    }
                }
            }
        }
    }
    
   
	public static int DiferenciaFechas (Fecha fecha1,Fecha fecha2)
	{
        int fecha1EnDias,fecha2EnDias;

        //calculamos el total de dias de ambas fechas
        fecha1EnDias = fecha1.transformarEnDias();
        fecha2EnDias = fecha2.transformarEnDias();

        if (fecha1EnDias>fecha2EnDias)
        {
            return (fecha1EnDias-fecha2EnDias);
        }
        else
        {
                if (fecha1EnDias<fecha2EnDias)
                {
                    return (fecha2EnDias-fecha1EnDias);
                }
                else
                {
                    return 0;
                }
         }

    }
	
	
	//El siguiente metodo transforma cualquier fecha valida en dias
    public int transformarEnDias()
    {
    	int fechaEnDias;
        fechaEnDias= this.mesADia() + (this.a*365)+ this.d - 365 ;
        return fechaEnDias;
    }
    
    public int mesADia()
    {
        switch(this.m)
        {
	        case 1: return 0;
	        case 2: return 31;
	        case 3: return 59;
	        case 4: return 90;
	        case 5: return 120;
	        case 6: return 151;
	        case 7: return 181;
	        case 8: return 212;
	        case 9: return 243;
	        case 10: return 273;
	        case 11: return 304;
	        case 12: return 334;
	        default: return 0;
        }
    }
	
    
    
    
    //suma dias a una fecha dada para crear otra fecha
    public Fecha sumarDias(int dias)
    {
    	int fechaEnDias,nuevaFechaEnDias;
    	Fecha fechaNueva;
    	
    	fechaEnDias = this.transformarEnDias();
    	nuevaFechaEnDias = fechaEnDias + dias;
    	fechaNueva = Fecha.transformarEnFecha(nuevaFechaEnDias);
    	return fechaNueva;
    }

    
    
    // transforma cualquier numero de dias en una fecha valida
    public static Fecha transformarEnFecha(int dias)
    {
    	int año=1,mes=1;
    	if(dias>365)//si es mas de un año
    	{
    		año=(dias/365)+1;//pasamos a años
    		dias=dias%365;//calculamos los dias restantes
    		if(dias==0)año--;//si no quedan dias restantes, restamos un año porque es del año anterior
    	}
    	else//es el año 1
    	{
    		año=1;
    		dias=dias%365;
    	}
    	
    	if(dias==0)//si es el ultimo dia del año
    	{
    		mes=12;
    		dias=31;
    	}
    	else//calculamos mes y dia a partir de los dias restantes
    	{
        	if((dias>=1)&&(dias<=31))
        		mes=1;
        	else
        	{
        		if((dias>31)&&(dias<=59))
        		{
        			mes=2;
        			dias=dias-31;
        		}
        		else
        		{
        			if((dias>59)&&(dias<=90))
        			{
        				mes=3;
        				dias=dias-59;
        			}
        			else
        			{
        				if((dias>90)&&(dias<=120))
        				{
        					mes=4;
        					dias=dias-90;
        				}
        				else
        				{
        					if((dias>120)&&(dias<=151))
        					{
        						mes=5;
        						dias=dias-120;
        					}
        					else
        					{
        						if ((dias>151)&&(dias<=181)) 
        						{
									mes=6;
									dias=dias-151;
								}
        						else 
        						{
									if ((dias>181)&&(dias<=212)) 
									{
										mes=7;
										dias=dias-181;
									} 
									else
									{
										if ((dias>212)&&(dias<=243))
										{
											mes=8;
											dias=dias-212;
										}
										else
										{
											if ((dias>243)&&(dias<=273))
											{
												mes=9;
												dias=dias-243;
											}
											else 
											{
												if ((dias>273)&&(dias<=304))
												{
													mes=10;
													dias=dias-273;
												} 
												else 
												{
													if ((dias>304)&&(dias<=334))
													{
														mes=11;
														dias=dias-304;
													}
													else
													{
														if((dias>334)&&(dias<365))
														{
															mes=12;
															dias=dias-334;
														}

													}

												}

											}

										}

									}
								}
        					}
        				}
        			}
        		}
        	}
    	}
    	Fecha fecha = new Fecha(dias,mes,año);
    	return fecha;
    }

    public int sacaraño()
    {
        return (this.a);
    }


    public int sacarmes()
    {
        return (this.m);
    }

    public int sacardia()
    {
        return (this.d);
    }
    
    
	////////////////////CALCULA EL DÍA DE LA SEMANA DE LA VENTANA	
	int calcul()
	{
		Integer day= new Integer(this.d);//(CUAL ES EL INDICE DEL DÍA 1..31 );
	    Integer month = new Integer(this.m);//(NUMERO DEL MES 1..12);
	    Integer year =new Integer(this.a);//(AÑO );
	    int A=2003;int M;
	    int [] T=new int[12];
	    T[0]=31;
	    T[1]=28;
	    T[2]=31;
	    T[3]=30;
	    T[4]=31;
	    T[5]=30;
	    T[6]=31;
	    T[7]=31;
	    T[8]=30;
	    T[9]=31;
	    T[10]=30;
	    T[11]=31;
		int N=0;int result=10;
		if((year-year/4*4)!=0 && month==2 && day==29)       result=10;
		else
		{
			if(year<A)
			{
				A--;
				M=12;
				while(year<A)
				{
					if((year-year/4*4)==0)
					{
						N=N+52*7+2;
					}
					else
						N=N+52*7+1;
					A--;
				}
				while(month<M)
				{
					N=N+T[month-1];
					M--;
				}
				N=N+T[M-1]-day+1;
				if((A-A/4*4)==0 && month<=2)
					N++;
				result=N-N/7*7;
				if(result!=0)   
					result=7-result;
			}
			A=2003;
			if(year>=A)
			{
				M=1;
				while(year>A)
				{
					if((A-A/4*4)==0)
						N=N+52*7+2;
					else
						N=N+52*7+1;
					A++;
				}
				while(month>M)
				{
					N=N+T[M-1];
					M++;
				}
				N=N+day-1;
				if((A-A/4*4)==0 && M>2)
					N++;
				result=N-N/7*7;
			}
		}
		return result;
	}
		    
}
