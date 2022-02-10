package itac;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.math.BigDecimal;
import static javax.swing.JOptionPane.showMessageDialog;
public class Itac {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    	
    	int Opcao;
        double Luz,Agua,Iptu,Internet;
    	String Nomes[] = new String[10];
    	int Pessoas[] = new int[10];
    	int Quartos[] = new int[10];
    	double Vpagar[] = new double[10];
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
       
        Date x1 = new Date();
    	System.out.print("Aluguel Administration "+sdf1.format(x1));
        System.out.print("\n\nInforme o valor da internet: ");
        Internet = scan.nextDouble();
        BigDecimal InternetCalc = new BigDecimal(Internet);
        System.out.print("\n\nInforme o valor do iptu: ");
        Iptu = scan.nextDouble();
        BigDecimal IptuCalc = new BigDecimal(Iptu);
        System.out.print("Informe o valor da conta de agua: ");
        Agua = scan.nextDouble();
        BigDecimal AguaCalc = new BigDecimal(Agua);
        System.out.print("Informe o valor da conta de luz: ");
        Luz = scan.nextDouble();
        BigDecimal LuzCalc = new BigDecimal(Luz);
        //Somar dois valores big decimal
        // res = Teste.add(Teste2);
        //System.out.printf("Resultado: %.2f%n",res);
    	System.out.print("\nDigite a quantidade de pessoas que sera cadastrada de [0 a 10]: ");
    	Opcao = scan.nextInt();
    
	if(Opcao > 10){
            System.out.print("O numero precisa ser menor ou igual a 10");
    	}
    	else{
    	for(int num=0;num<Opcao;num++){
            System.out.print("\nCadastro #"+num);
            System.out.print("\nInforme o nome do locatario: ");
            Nomes[num] = scan.next();
            System.out.print("Informe a quantidade de pessoas que alugaram a casa: ");
            Pessoas[num] = scan.nextInt();
            System.out.print("Informe o numero do quarto alugado: ");
            Quartos[num] = scan.nextInt();
            System.out.print("Valor pago pelo locatario: ");
            Vpagar[num] = scan.nextDouble();
        }
        double VpagarTotal = Vpagar[0]+Vpagar[1]+Vpagar[2]+Vpagar[3]+Vpagar[4]+Vpagar[5]+Vpagar[6]+Vpagar[7]+Vpagar[8]+Vpagar[9];
        BigDecimal VpagarTotalCalc = new BigDecimal(VpagarTotal);
        
        BigDecimal Res = new BigDecimal("0");
        Res = VpagarTotalCalc.subtract(AguaCalc);
        
        BigDecimal Res1 = new BigDecimal("0");
        Res1 = Res.subtract(LuzCalc);
        
        BigDecimal Res2 = new BigDecimal("0");
        Res2 = Res1.subtract(InternetCalc);
        
        System.out.print("\n\nDinheiro do alugel: "+VpagarTotalCalc);
        showMessageDialog(null, "Aguarde...\nEfetuando calculo!");
        System.out.printf("\nLucro: "+VpagarTotalCalc+" - Luz: "+Luz+" - Agua: "+Agua+" - Internet: "+Internet+" = %.2f%n",Res2);
        
        System.out.print("\nLista de cadastro dos clientes: ");
        for(int Cont=0;Cont<Opcao;Cont++){
            System.out.print("\n"+Cont+"| Nome: "+Nomes[Cont]+" Quantidade de acompanhantes: "+Pessoas[Cont]+" Quarto alugado: "+ Quartos[Cont]+" Valor pago: "+Vpagar[Cont]);
        }
        scan.close();
    }
  }
}
