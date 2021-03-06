package nl.fhict.intellicloud.answers;

import android.os.Parcel;
import android.os.Parcelable;

public class Answer implements Parcelable {
	
	private int id;
	private String answer;
	private Question question;
	private User answerer;
	private AnswerState answerState;
	
	public Answer(int id, String answer, Question question, User answerer, AnswerState answerState){
		this.id = id;
		this.answer = answer;
		this.question = question;
		this.answerer = answerer;
		this.answerState = answerState;
	}
	
	public Answer (Parcel in){
		id = in.readInt();
		answer = in.readString();
		question = in.readParcelable(Question.class.getClassLoader());
		answerer = in.readParcelable(User.class.getClassLoader());
		answerState = in.readParcelable(AnswerState.class.getClassLoader());
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public Question getQuestion() {
		return question;
	}
	
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	public User getAnswerer() {
		return answerer;
	}
	
	public void setAnswerer(User answerer) {
		this.answerer = answerer;
	}
	
	public AnswerState getAnwserState() {
		return answerState;
	}
	
	public void setAnwserState(AnswerState anwserState) {
		this.answerState = anwserState;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(id);
		dest.writeString(answer);
		dest.writeParcelable(question, 0);
		dest.writeParcelable(answerer, 0);
		dest.writeParcelable(answerState, 0);
	}
	
	public static final Parcelable.Creator<Answer> CREATOR = new Parcelable.Creator<Answer>() {
		public Answer createFromParcel (Parcel in){
			return new Answer(in);
		}

		@Override
		public Answer[] newArray(int size) {
			return new Answer[size];
		}
	};
}
