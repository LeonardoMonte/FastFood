package br.ufrpe.fastFood.beans;

	public class Bebida extends Produto {
	
		private String sabor;
		
		public Bebida(String nome, double valor, String codigo, String sabor){
			super(nome, valor, codigo);
						
			this.sabor = sabor;
		}
		
		public String getSabor() {
			return sabor;
		}

		public String toString() {
			StringBuffer buffer =  new StringBuffer();
			buffer.append("==========================\n");
			buffer.append("       PRODUTO \n");
			buffer.append("Produto: "+ this.getNome() +"\n");
			buffer.append("Codigo: " + this.getCodigo() + "\n");
			buffer.append("Valor: " + this.getValor() + "\n");
			buffer.append("sabor: " + this.getSabor());
			
			return buffer.toString();
		}
		
}
