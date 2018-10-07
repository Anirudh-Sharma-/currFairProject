package interview.Message;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepository messageRepository;
	
	public List<Message> getAllMessages(){
		List<Message> messages = new ArrayList<>();
		messageRepository.findAll().forEach(messages::add);
		return messages;
	}
	
	public Message getMessage(String userId){
		return messageRepository.findOne(userId);
	}
	
	public Message addMessage(Message message){
		Message newMessage = messageRepository.save(message);
		return newMessage;
	}
	
	public Message updateMessage(String userId, Message message){
		Message updatedMessage = messageRepository.save(message);
		return updatedMessage;
	}
	
	public void deleteMessage(String userId){
		messageRepository.delete(userId);
	}
	
}
