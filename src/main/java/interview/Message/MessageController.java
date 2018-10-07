package interview.Message;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@RequestMapping(method=RequestMethod.GET,value="/message")
	public List<Message> getMessages(){
		return messageService.getAllMessages();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/message/{userId}")
	public Message getMessage(@PathVariable String userId){
		return messageService.getMessage(userId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/message" )
	public ResponseEntity<Void> addMessage(@RequestBody Message message) throws URISyntaxException{
		Message newMessage = messageService.addMessage(message);
		if (newMessage == null)
			return ResponseEntity.noContent().build();
		else{
			return ResponseEntity.created(new URI("/message/"+newMessage.getUserId())).build();
		}
		
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/message/{userId}")
	public Message getMessage(@PathVariable String userId,@RequestBody Message message){
		 return messageService.updateMessage(userId, message);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/message/{userId}")
	public void deleteMessage(@PathVariable String userId){
		 messageService.deleteMessage(userId);
	}
}
