package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entities.Instructor;
import com.nt.entities.InstructorDetail;

import javassist.bytecode.stackmap.BasicBlock.Catch;

public class CreateOneToOneTest {

	public static void main(String[] args) {

		// create SESSIONFACTORY
		SessionFactory sessionFactory = new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		;
		// create SESSION
		Session session = sessionFactory.getCurrentSession();
		
		try {
	/*		// create the objects
			Instructor tempInstructor = new Instructor();
			tempInstructor.setFirstName("NAGABABU");
			tempInstructor.setLastName("BARMA");
			tempInstructor.setEmail("b.nagababu146@gmail.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail();
			tempInstructorDetail.setYoutubeChannel("http://www.barma.com/youtube");
			tempInstructorDetail.setHobby("Cricket!!");
*/
			Instructor tempInstructor2 = new Instructor();
			tempInstructor2.setFirstName("SRINIVAS");
			tempInstructor2.setLastName("BARMA");
			tempInstructor2.setEmail("barma.srinivas80@gmail.com");

			InstructorDetail tempInstructorDetail2 = new InstructorDetail();
			tempInstructorDetail2.setYoutubeChannel("http://www.barmavasu.com/youtube");
			tempInstructorDetail2.setHobby("Chess!!");
			
			// associate the objects
			tempInstructor2.setTempInstructorDetail(tempInstructorDetail2);
			
			// start Transaction
			Transaction transaction = session.beginTransaction();
            //save the instructor
			//
			//NOTE:this will ALSO save the details object
			/*//beacuse of CascadeType.ALL
			System.out.println("saving instructor"+tempInstructor);
			Integer i1=(Integer)session.save(tempInstructor);
			*/
			System.out.println("saving instructor"+tempInstructor2);
			Integer i2=(Integer)session.save(tempInstructor2);
			
			//commit transaction
            session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
