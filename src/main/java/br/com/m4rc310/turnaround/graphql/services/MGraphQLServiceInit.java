package br.com.m4rc310.turnaround.graphql.services;

import java.util.Date;

import org.reactivestreams.Publisher;
import org.springframework.stereotype.Service;

import br.com.m4rc310.gql.dto.MUser;
import br.com.m4rc310.gql.mappers.annotations.MDate;
import br.com.m4rc310.gql.services.MService;
import br.com.m4rc310.turnaround.graphql.configs.MConst;
import br.com.m4rc310.turnaround.graphql.prices.MPrice;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.GraphQLSubscription;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;


@Service
@GraphQLApi
public class MGraphQLServiceInit extends MService implements MConst {
	

	
	@GraphQLQuery(name = QUERY$test_service, description = DESC$query_test_service)
	public String testeService() {
		return "OK";
	}
	
	
	@MDate(unixFormat = true)
	@GraphQLQuery(name = "${query.date.test}")
	public Long dateTest() {
		return 553987709L;
	}
	
	
	@GraphQLMutation(name = "${mutation.send.price}")
	public MPrice sendPrice(MPrice price) {
		return price;
	}
	
	
//	@MDate
//	@GraphQLSubscription(name = "test_data")
	public Publisher<Date> testDateSubscription(){
//		String id = "sub_date_test";
//		return flux.publish(Date.class, id, new Date());
//		return Flux.interval(Duration.ofSeconds(1)).map(tike -> new Date());
		return null;
	}
	
	
	
	
	@GraphQLSubscription
	public Publisher<MUser> taskStatusChanged() {
		
		String id = "user";
		
		MUser user = new MUser();
		user.setUsername("mlsilva");
		user.setCode(270881L);
		return flux.publish(MUser.class, id, user);
		
//		Date price = new Date();
//	    return Flux.create(subscriber -> subscribers.add("OK", subscriber.onDispose(() -> subscribers.remove("OK", subscriber))), FluxSink.OverflowStrategy.LATEST);
	}
	
	
	
}
