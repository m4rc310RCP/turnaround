package br.com.m4rc310.turnaround.graphql.prices;

import java.math.BigDecimal;
import java.util.Date;

import br.com.m4rc310.gql.mappers.annotations.MDate;
import br.com.m4rc310.turnaround.graphql.configs.MConst;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.types.GraphQLType;
import lombok.Data;

@Data
@GraphQLType(name = "${type.price}")
public class MPrice implements MConst {
	@GraphQLQuery(name = "${symbol.coin}")
	private String symbol;
	@GraphQLQuery(name = "${name.coin}")
	private String name;
	@GraphQLQuery(name = "${type.coin}")
	private String type;
	@GraphQLQuery(name = "${value.price}")
	private BigDecimal value;
	@MDate
	@GraphQLQuery(name = "${date.price}")
	private Date date;
}
