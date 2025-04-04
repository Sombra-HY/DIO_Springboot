package br.com.dio.service;

import java.util.List;

import br.com.dio.exception.ProductEmpentyExceotion;
import br.com.dio.exception.ProductValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dio.entity.Produto;
import br.com.dio.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	public Produto save(Produto produto) throws Exception {
		if (produto.getNome() == null || produto.getPreco() == null)
			throw new ProductEmpentyExceotion();
		if(produto.getPreco() <= 0){
			throw new ProductValueException();
		}
		return repository.save(produto);
	}

	public Produto findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Produto> findAll() {
		return repository.findAll();
	}
}