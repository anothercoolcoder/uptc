#include <iostream>
#include <cmath>

//Variables del menú
bool iterar;
int opc;

//Variables programa N°1 Área de un polígono regular
int nLados;
double longitudLados, numerador, denominador, areaPoligono;

//Variables programa N°2 Ecuación cuadrática
double coefA,coefB,coefC,discriminante,solucionX1_,solucionX2_;

//Variables programa N°3 Área triángulo (Fórmula de herón)
double ladoA,ladoB,ladoC,semiperimetro,areaTriang;


int main() {
    
    iterar = true;
    
    std::cout<<"                Menú";
    std::cout<<"\n1. Área de un polígono regular";
    std::cout<<"\n2. Ecuación cuadrática";
    std::cout<<"\n3. Área triángulo (Fórmula de Herón)";
    std::cout<<"\n4. Salir del menú";
    std::cout<<"\n\nDigite una opción: ";
    std::cin>>opc;
    while(true){
    switch (opc) {
        
        case 1:
        
            for (int limpiar = 0; limpiar < 50; limpiar++) {
            std::cout<<"\n";
            }
            std::cout<<"\nDigite el número de lados el polígono regular: ";
            std::cin>>nLados;
        
            if (nLados >= 3) {
            
                std::cout<<"Digite la longitud de los lados: ";
                std::cin>> longitudLados;
            
                if (longitudLados > 0) {
                
                    numerador =nLados*pow(longitudLados,2);
                    denominador =4*tan(M_PI/nLados);
                    areaPoligono =numerador/denominador;
                
                    std::cout << "\nEl área calculada del polígono regular con "<<nLados<<" lados, cada lado de longitud "<< longitudLados << " es = " << areaPoligono; 
                
                    } else {
                
                        std::cout << "¡¡¡Error... La longitud debe ser un dato real positivo!!!";
                
                        }
            
                    } else {
            
                    std::cout<<"¡¡¡Error... La cantidad de lados del polígono regular, tiene que ser un dato entero positivo mayor o igual a 3!!";
                        }
        
            break;
        
        case 2:
        
            for (int limpiar = 0; limpiar < 50; limpiar++) {
            std::cout<<"\n";
            }
            //Digitar los coeficientes a, b, c
            std::cout<<"\nDigite el primer coeficiente (a) de la ecuación cuadrática: ";
            std::cin>>coefA;
            std::cout<<"Digite el segundo coeficiente (b) de la ecuación cuadrática: ";
            std::cin>>coefB;
            std::cout<<"Digite el tercer coeficiente (c) de la ecuación cuadrática: ";
            std::cin>>coefC;
    
            if (coefA != 0) {
        
                discriminante = pow(coefB,2) - 4*coefA*coefC;
                std::cout<<"\nEl discriminante es "<<discriminante;
        
                if (discriminante >= 0) {
            
                    solucionX1_ = (-coefB - std::sqrt(discriminante))/(2*coefA);
            
                    solucionX2_ = (-coefB + std::sqrt(discriminante))/(2*coefA);
            
                    std::cout<<"\nLa solución X1 = "<<solucionX1_<<"\nla solución X2 = "<<solucionX2_;
            
                    } else {
            
                    std::cout<<"\nLa ecuación no tiene una solución real";
            
                        }
        
            } else {
        
        std::cout<<"\n¡¡¡Error...La solución de la ecuación es imposible!!!";
        
                }
        
            break;
        
        case 3:
        
            for (int limpiar = 0; limpiar < 50; limpiar++) {
                std::cout<<"\n";
            }
            std::cout<<"\nDigite la longitud del lado A: ";
            std::cin>>ladoA;
    
            if (ladoA>0) {
        
                std::cout<<"Digite la longitud del lado B: ";
                std::cin>>ladoB;
        
                if (ladoB>0) {
            
                std::cout<<"Digite la longitud del lado C: ";
                std::cin>>ladoC;
            
                    if (ladoC>0) {
                
                        //Verificamos la desigualdad de Herón
                        if ((ladoA + ladoB > ladoC) && (ladoA + ladoC > ladoB) && (ladoB + ladoC > ladoA)) {
                    
                            semiperimetro = (ladoA+ladoB+ladoC)/2;
                            areaTriang = sqrt(semiperimetro*(semiperimetro-ladoA)*(semiperimetro-ladoB)*(semiperimetro-ladoC));
                    
                            std::cout<<"\nEl área del triángulo es: "<< areaTriang;
                    
                            } else {
                    
                                std::cout<<"\n¡¡¡Error...La longitud de los lados no forman un triángulo válido!!!";
                    
                                }
                
                        } else {
                
                            std::cout<<"\n¡¡¡Error...El lado C debe ser un dato numperico real positivo!!!";
                
                            }
            
                    } else {
            
                        std::cout<<"\n¡¡¡Error...El lado B debe ser un dato numérico real positivo!!!";
            
                        }
        
                } else {
        
                    std::cout<<"\n¡¡¡Error...El lado A debe ser un dato numérico real positivo!!!";
        
                    }
        
            break;
        
        case 4:
            for (int limpiar = 0; limpiar < 50; limpiar++) {
            std::cout<<"\n";
            }
            std::cout<<"\n\n\n\n";
            std::cout<<"                Saliendo del menú";
            iterar = false;
            break;
        
        default:
        std::cout<<std::endl<<"        Opción no válida";
    }

    }
    
    std::cin.ignore();
    std::cin.get();
    
    return 0;
}