# DBMS Project
# Data Population

from random import randint as R
import random
import csv

SID = ["SID"+"0"*(7-len(str(i)))+str(i) for i in range(1000)]
GID = ["GID"+"0"*(7-len(str(i)))+str(i) for i in range(1000)]
PID = ["PAY"+"0"*(7-len(str(i)))+str(i) for i in range(1000)]
TID = ["TID"+"0"*(7-len(str(i)))+str(i) for i in range(1000)]
ACC = ["ACTNO"+"0"*(7-len(str(i)))+str(i) for i in range(1000)]

Phone = [str(R(7000000001,9999999999)) for i in range(5000)]


Male = ['Viresh Patel', 'Sampat Patel', 'Prabhakar Singh', 'Mohamad Raj', 'Daman Khan', 'Sevak Raj', 'Janardan Raj', 'Karunakar Kumar', 'Pavalan Ismail', 'Hritish Ismail', 'Daiwik Jain', 'Asgar Jain', 'Pinaki Singh', 'Ulagan Raj', 'Natraj Jain', 'Bibhavasu Patel', 'Achintya Singh', 'Jugnu Patel', 'Rafat Kumar', 'Prabodh Kumar', 'Navroz Ismail', 'Umed Khan', 'Fadi Patel', 'Divyesh Raj', 'Ellu Khan', 'Jaswant Patel', 'Premal Singh', 'Vallabh Kumar', 'Mihir Singh', 'Talleen Raj', 'Narasimha Kumar', 'Chanchal Patel', 'Sunanda Ismail', 'Gunaratna Singh', 'Salaman Ismail', 'Mithilesh Jain', 'Sulekh Patel', 'Viplab Kumar', 'Balagovind Ismail', 'Sadanand Raj', 'Trailokva Ismail', 'Trailokva Patel', 'Bhupathi Jain', 'Samudra Patel', 'Animish Raj', 'Indushekhar Kumar', 'Chandresh Jain', 'Mukul Jain', 'Jyotirdhar Ismail', 'Pranav Jain', 'Satyasheel Jain', 'Viswas Raj', 'Vishvajit Jain', 'Ekalavya Raj', 'Lalitmohan Khan', 'Haresh Jain', 'Bhim Singh', 'Jagajeet Ismail', 'Indeever Khan', 'Pavani Singh', 'Saurabh Jain', 'Brijesh Jain', 'Hirendra Jain', 'Sumit Khan', 'Anu Raj', 'Rishabh Singh', 'Dasharathi Ismail', 'Ekalinga Raj', 'Girish Jain', 'Sachet Jain', 'Omswaroop Raj', 'Jalal Singh', 'Rehman Khan', 'Bhaumik Singh', 'Kulik Singh', 'Kriday Khan', 'Rasul Raj', 'Ibrahim Patel', 'Ajamil Ismail', 'Balamohan Patel', 'Srijan Patel', 'Sudhanssu Khan', 'Balwant Raj', 'Yash Jain', 'Elumalai Khan', 'Shankha Raj', 'Madangopal Patel', 'Jagadip Patel', 'Balanath Kumar', 'Neelmadhav Kumar', 'Shashwat Singh', 'Nithilan Kumar', 'Gandhar Jain', 'Timir Khan', 'Milind Jain', 'Abhinava Ismail', 'Lav Jain', 'Gulab Jain', 'Anshumat Patel', 'Paramartha Khan', 'Amalendu Raj', 'Dhananjay Ismail', 'Shantipriya Patel', 'Pranjivan Singh', 'Arokya Raj', 'Budhil Khan', 'Bindusar Raj', 'Karunashankar Jain', 'Ananda Patel', 'Jatya Kumar', 'Pradosh Singh', 'Sacchidananda Raj', 'Bahumanya Khan', 'Gurcharan Singh', 'Jugnu Singh', 'Ajinkya Singh', 'Ranjan Kumar', 'Deepesh Patel', 'Hariprasad Patel', 'Mahipal Singh', 'Indumat Ismail', 'Gangeya Singh', 'Isaivalan Singh', 'Jaimini Kumar', 'Faraz Jain', 'Tapasendra Jain', 'Nedumaran Ismail', 'Sahay Raj', 'Saeed Ismail', 'Suchir Ismail', 'Shubhankar Khan', 'Vedanga Raj', 'Sahas Khan', 'Chellapan Jain', 'Shvetang Khan', 'Phalgun Khan', 'Vedprakash Patel', 'Abhayaprada Singh', 'Nandi Ismail', 'Adhipa Patel', 'Kunjabihari Jain', 'Jogindra Ismail', 'Kandarpa Khan', 'Jagadayu Khan', 'Abhyudita Singh', 'Hurditya Jain', 'Kriday Kumar', 'Shantiprakash Patel', 'Abhijit Raj', 'Sutejas Patel', 'Kaustubh Patel', 'Kirtikumar Raj', 'Faiyaz Khan', 'Acarya Raj', 'Bhagyanandana Jain', 'Ganjan Singh', 'Japendra Singh', 'Tarit Khan', 'Subhan Jain', 'Utkarsh Patel', 'Brijmohan Raj', 'Ekaraj Kumar', 'Sandananda Kumar', 'Akalpa Jain', 'Acalapati Raj', 'Omrao Ismail', 'Senajit Kumar', 'Trishanku Khan', 'Dalbhya Jain', 'Shivshankar Patel', 'Indrakanta Kumar', 'Anirudhha Patel', 'Varindra Jain', 'Krishnadeva Patel', 'Bodhan Singh', 'Madhur Kumar', 'Iniyavan Kumar', 'Chapal Kumar', 'Mahadev Khan', 'Manibhushan Patel', 'Senthamarai Patel', 'Satyankar Ismail', 'Manuj Raj', 'Jasapal Ismail', 'Puskara Jain', 'Kamat Ismail', 'Balram Jain', 'Dasharathi Jain', 'Harshad Khan', 'Atul Kumar', 'Nithik Ismail', 'Arjun Khan', 'Arihant Jain', 'Sragvibhushan Ismail', 'Janith Singh', 'Tarak Ismail', 'Saroj Kumar', 'Jayashekhar Singh', 'Ratannabha Patel', 'Nirbhay Khan', 'Devanand Ismail', 'Sitakanta Jain', 'Shyamsundar Jain', 'Dhwani Raj', 'Sudhakar Khan', 'Gulab Kumar', 'Hashmat Ismail', 'Hemanga Ismail', 'Nilay Kumar', 'Omar Patel', 'Parasmani Khan', 'Radhakrishna Raj', 'Jenya Raj', 'Gursharan Jain', 'Navin Kumar', 'Manas Raj', 'Chandrakanta Ismail', 'Vetrival Jain', 'Martanda Singh', 'Shambhu Patel', 'Ekanath Khan', 'Vishvajit Patel', 'Charu Patel', 'Hiranmay Jain', 'Yamajith Singh', 'Vijay Ismail', 'Suvrata Jain', 'Jagadish Singh', 'Mangesh Khan', 'Niral Patel', 'Ashu Kumar', 'Bahubali Patel', 'Udayachal Raj', 'Anbu Jain', 'Hemadri Patel', 'Manasi Raj', 'Ulhas Khan', 'Mahanth Jain', 'Shams Singh', 'Murad Patel', 'Ramchandra Raj', 'Gandharaj Khan', 'Abhyudaya Khan', 'Uddhar Singh', 'Ilavenil Ismail', 'Mangal Patel', 'Kandarpa Kumar', 'Sulochan Ismail', 'Mohak Ismail', 'Akalpa Khan', 'Rajdulari Patel', 'Prem Raj', 'Krishnadeva Khan', 'Panduranga Singh', 'Sourish Kumar', 'Paresh Jain', 'Sugreev Khan', 'Charu Raj', 'Sachin Singh', 'Palaniappan Patel', 'Balamohan Ismail', 'Chiranjeev Raj', 'Ravi Jain', 'Anuha Kumar', 'Nabhi Patel', 'Kamlesh Kumar', 'Musheer Raj', 'Indulal Raj', 'Vrishin Ismail', 'Jaisal Khan', 'Devadatta Kumar', 'Shubhendu Raj', 'Nimai Raj', 'Samendra Jain', 'Priya Singh', 'Umang Singh', 'Shripati Raj', 'Manikandan Kumar', 'Ravi Patel', 'Haresh Ismail', 'Vighnesh Kumar', 'Sacchidananda Patel', 'Jatan Khan', 'Milind Patel', 'Gyan Singh', 'Hakesh Singh', 'Bandhul Raj', 'Subodh Raj', 'Rishikesh Patel', 'Ravikiran Patel', 'Tanuj Patel', 'Yashodhara Khan', 'Thayanban Jain', 'Farhat Singh', 'Ellu Ismail', 'Uttiya Singh', 'Arivumadhi Jain', 'Baladhi Jain', 'Dhevan Jain', 'Arijit Patel', 'Ajamil Jain', 'Shriranga Kumar', 'Harsh Kumar', 'Taizeen Kumar', 'Ellu Jain', 'Niranjan Patel', 'Nikhat Singh', 'Iri Kumar', 'Murarilal Khan', 'Shankha Ismail', 'Rizvan Raj', 'Ashvin Khan', 'Bhajan Jain', 'Uddhar Jain', 'Ainesh Kumar', 'Deepesh Kumar', 'Maniram Khan', 'Chandak Khan', 'Ponnan Kumar', 'Bhuvan Raj', 'Amalesh Jain', 'Pramod Singh', 'Chintya Ismail', 'Karun Ismail', 'Swami Raj', 'Amitesh Khan', 'Shashwat Ismail', 'Ayyapan Khan', 'Ramavatar Patel', 'Sushobhan Khan', 'Kanishka Jain', 'Yadav Singh', 'Lakshmikanta Kumar', 'Sayam Kumar', 'Devak Raj', 'Sahay Singh', 'Debashis Patel', 'Natesh Patel', 'Pallav Raj', 'Rushil Khan', 'Mahadev Patel', 'Khalid Khan', 'Sacchidananda Khan', 'Bankebihari Singh', 'Kailash Patel', 'Ilamurugu Khan', 'Kabir Jain', 'Bhaumik Jain', 'Divakar Kumar', 'Rashmil Raj', 'Faisal Raj', 'Nityagopal Khan', 'Ranjan Khan', 'Champak Kumar', 'Suryabhan Khan', 'Yamajith Raj', 'Jusal Raj', 'Kandarpa Raj', 'Kartar Raj', 'Dheer Kumar', 'Sharadindu Patel', 'Dharmesh Raj', 'Manoranjan Singh', 'Mahavir Kumar', 'Mahaj Kumar', 'Satindra Raj', 'Nikunj Jain', 'Tapasendra Patel', 'Lakshmidhar Khan', 'Pradosh Raj', 'Indukanta Patel', 'Gunjan Singh', 'Rajanikanta Jain', 'Krishnamurari Khan', 'Swaminath Jain', 'Vineet Kumar', 'Nand Khan', 'Sabhya Khan', 'Navin Singh', 'Nirav Raj', 'Purnanada Kumar', 'Jashan Khan', 'Habib Patel', 'Prithu Raj', 'Divyendu Kumar', 'Ankit Kumar', 'Dharma Singh', 'Narun Raj', 'Sohan Jain', 'Madhu Patel', 'Partha Patel', 'Balamani Kumar', 'Avanindra Kumar', 'Kunja Kumar', 'Pratul Kumar', 'Sriram Jain', 'Tarpan Patel', 'Ashraf Patel', 'Mekhal Khan', 'Jalindra Jain', 'Faisal Kumar', 'Bhupendra Kumar', 'Satrijit Ismail', 'Dharmadas Ismail', 'Aniteja Khan', 'Nityanand Raj', 'Anurag Kumar', 'Asit Jain', 'Rishikesh Singh', 'Subhan Kumar', 'Kaviraj Patel', 'Basistha Ismail', 'Achintya Ismail', 'Dharmendra Raj', 'Pradyumna Kumar', 'Apparajito Khan', 'Nabarun Kumar', 'Sharan Khan', 'Aakar Raj', 'Kirtikumar Jain', 'Rakesh Raj', 'Sarvadaman Ismail', 'Nandan Ismail', 'Vanajit Ismail', 'Harsh Ismail', 'Savar Kumar', 'Chintamani Kumar', 'Irshaad Raj', 'Pritam Patel', 'Bipin Ismail', 'Basudha Raj', 'Patakin Khan', 'Shashimohan Khan', 'Sharan Raj', 'Jitendra Singh', 'Shiromani Khan', 'Nachiketa Jain', 'Ashis Patel', 'Tariq Jain', 'Sajal Singh', 'Umesh Ismail', 'Anurag Ismail', 'Hiresh Raj', 'Talat Khan', 'Ekaraj Patel', 'Meghashyam Khan', 'Devarsi Jain', 'Rupesh Kumar', 'Premanand Kumar', 'Prachetas Patel', 'Ankush Jain', 'Rushil Ismail', 'Brahmabrata Raj', 'Rasbihari Raj', 'Jairaj Singh', 'Aakar Kumar', 'Fadl Patel', 'Shishirkumar Jain', 'Chirantan Kumar', 'Balagovind Khan', 'Madhav Raj', 'Baladhitya Singh', 'Indivar Khan', 'Manohar Patel', 'Kashyap Patel', 'Aghat Khan', 'Indeever Kumar', 'Kandan Jain', 'Kartikeya Kumar', 'Rasesh Patel', 'Vipra Ismail', 'Senmal Singh', 'Timirbaran Raj', 'Ganaka Jain', 'Prajeet Ismail', 'Pukhraj Ismail', 'SendhilNathan Patel', 'Kashiprasad Ismail', 'Makarand Ismail', 'Ved Raj', 'Vikranta Raj', 'Vrishin Kumar', 'Raghuvir Singh', 'Rebanta Ismail', 'Osman Raj', 'Acalendra Singh', 'Abhirup Patel', 'Satyankar Khan', 'Arulchelvan Patel', 'Ekram Singh', 'Etash Jain', 'Vikranta Khan', 'Arun Jain', 'Bahuleya Jain', 'Bhudev Singh', 'Palashkusum Raj', 'Devdas Raj', 'Indivar Jain', 'Anurag Raj', 'Satyasheel Kumar', 'Dharmendu Kumar', 'Pradyumna Khan', 'Fateen Singh', 'Jatan Kumar', 'Ranganath Kumar', 'Elilarasan Kumar', 'Anunay Kumar', 'Bhooshan Ismail', 'Jalil Ismail', 'Indrakanta Ismail', 'Lalitkumar Raj', 'Suhail Kumar', 'Udeep Singh', 'Shantanu Khan', 'Nirmanyu Singh', 'Quasim Singh', 'Ujwal Ismail', 'Shrikumar Ismail', 'Devarpana Kumar', 'Gaganvihari Jain', 'Kamlesh Jain', 'Dinesh Singh', 'Mangesh Raj', 'Uttiya Kumar', 'Anarghya Patel', 'Yogesh Ismail', 'Kanwaljeet Jain', 'Anshul Jain', 'Abhinabhas Singh', 'Jagath Jain', 'Sendhil Raj', 'Ratish Ismail', 'Ekambar Patel', 'Vendan Raj', 'Mahabala Khan', 'Chandrahas Ismail', 'Paravasu Singh', 'Riyaz Kumar', 'Syamantak Khan', 'Balagovind Patel', 'Nandan Khan', 'Ravikiran Khan', 'Shrikanta Singh', 'Gajanan Raj', 'Virendra Ismail', 'Pranet Kumar', 'Kathith Jain', 'Dheerendra Singh', 'Chaman Kumar', 'Upendra Kumar', 'Dayanand Patel', 'Nirmalya Jain', 'Seemanta Raj', 'Amitabh Singh', 'Avatar Kumar', 'Subodh Ismail', 'Hariraj Singh', 'Tapan Jain', 'Deepesh Khan', 'Akash Ismail', 'Indrajit Raj', 'Gangesh Singh', 'Pramath Singh', 'Sankara Khan', 'Avatar Khan', 'Shreyas Kumar', 'Avanindra Khan', 'Kishore Ismail', 'Deepit Khan', 'Kamod Ismail', 'Daksha Jain', 'Kapil Kumar', 'Chandrakanta Raj', 'Heramba Singh', 'Nadir Raj', 'Animish Singh', 'Ahmad Khan', 'Sanchay Jain', 'Amoha Jain', 'Shesh Jain', 'Dharanidhar Patel', 'Lakshman Kumar', 'Radhak Singh', 'Gandharva Khan', 'Chandrachur Ismail', 'Chandan Singh', 'Krishnakumar Patel', 'Ratul Ismail', 'Bhanudas Singh', 'Balgopal Jain', 'Jusal Ismail', 'Raghunandan Patel', 'Abhijvala Patel', 'Prasoon Raj', 'Prabhat Raj', 'Chandresh Kumar', 'Gurudutt Patel', 'Devadutt Khan', 'Balakrishna Singh', 'Taraprashad Singh', 'Phenil Ismail', 'Bhavesh Ismail', 'Abhilash Ismail', 'Anjuman Khan', 'Pralay Singh', 'Kush Raj', 'Baldev Ismail', 'Adil Patel', 'Indulal Patel', 'Timirbaran Khan', 'Pundalik Ismail', 'Nissim Kumar', 'Pukhraj Kumar', 'Habib Raj', 'Sujay Patel', 'Gulzarilal Kumar', 'Jayaditya Patel', 'Harinaksh Kumar', 'Aniteja Singh', 'Pyaremohan Singh', 'Yash Ismail', 'Vinod Kumar', 'Vismay Kumar', 'Madhur Patel', 'Kanan Ismail', 'Shrinivas Patel', 'Taraprashad Ismail', 'Ramprasad Raj', 'Saket Kumar', 'Dharmanand Jain', 'Sapan Patel', 'Hanuman Khan', 'Arka Jain', 'Nitin Kumar', 'Nimish Ismail', 'Raghunath Jain', 'Manavendra Raj', 'Bankim Raj', 'Pulakesh Khan', 'Megha Singh', 'Panmoli Khan', 'Maitreya Kumar', 'Mansukh Singh', 'Manas Jain', 'Quasim Raj', 'Arnesh Kumar', 'Shishir Kumar', 'Radhavallabh Raj', 'Anu Singh', 'Satyaprakash Khan', 'Pundalik Raj', 'Yudhajit Raj', 'Shahid Kumar', 'Unmesh Raj', 'Sadeepan Jain', 'Idris Khan', 'Bhanu Ismail', 'Akshit Singh', 'Mriganka Raj', 'Sudhanssu Patel', 'Agniprava Kumar', 'Pitambar Khan', 'Aachman Jain', 'Sitanshu Patel', 'Himanshu Kumar', 'Sudhir Singh', 'Ilavenil Kumar', 'Mriganka Khan', 'Mohul Patel', 'Nripendra Kumar', 'Misal Jain', 'Akshit Raj', 'Dev Jain', 'Prateep Raj', 'Abhimanyu Jain', 'Devamadana Patel', 'Gyan Khan', 'Ibhya Jain', 'Gulab Ismail', 'Sragvibhushan Patel', 'Rajarshi Jain', 'Rangith Ismail', 'Vaibhav Jain', 'Arka Kumar', 'Bhuvan Singh', 'Manprasad Jain', 'Ekalavya Jain', 'Manjeet Raj', 'Agniprava Singh', 'Sudhish Raj', 'Soman Khan', 'Lalit Kumar', 'Harishchandra Kumar', 'Abhimani Patel', 'Ottakoothan Khan', 'Kalpa Raj', 'Shami Kumar', 'Indrajeet Raj', 'Anunay Khan', 'Shyamal Khan', 'Krishnamurari Jain', 'Adhik Jain', 'Dharmachandra Khan', 'Fareed Patel', 'Pranjal Khan', 'Nambi Khan', 'Narsimha Ismail', 'Tilak Ismail', 'Anisa Raj', 'Chakrapani Raj', 'Gandhik Ismail', 'Thevan Patel', 'Abhisyanta Patel', 'Chapal Ismail', 'Shrivatsa Jain', 'Tathagata Khan', 'Hem Singh', 'Aadesh Singh', 'Satyakam Singh', 'Abhimoda Patel', 'Sambit Ismail', 'Sanjay Patel', 'Bibek Singh', 'Maruti Jain', 'Kinshuk Jain', 'Chitrabhanu Kumar', 'Prabhat Jain', 'Chitragupta Ismail', 'Siddharth Patel', 'Devya Ismail', 'Hansaraj Singh', 'Rishabh Raj', 'Osman Ismail', 'Sudhamay Jain', 'Manmohan Kumar', 'Chintya Khan', 'Deepak Khan', 'Balaaditya Kumar', 'Kripal Patel', 'Yoganand Patel', 'Padmapati Ismail', 'Neelotpal Raj', 'Chinmayananda Ismail', 'Daivya Jain', 'Narhari Singh', 'Sharadchandra Ismail', 'Shailendra Raj', 'Hemamdar Kumar', 'Balan Khan', 'Lakshmigopal Kumar', 'Seemanta Khan', 'Sunanda Kumar', 'Inbanathan Patel', 'Aslesh Singh', 'Jyotirmoy Singh', 'Falgu Kumar', 'Jagesh Ismail', 'Magadh Khan', 'Charuvindha Patel', 'Satish Ismail', 'Vrajamohan Jain', 'Shashanka Jain', 'Sukumar Raj', 'Narhari Khan', 'Nipun Ismail', 'Sayam Ismail', 'Sagar Singh', 'Ram Ismail', 'Aghat Jain', 'Mahesh Singh', 'Ibrahim Kumar', 'Kamal Kumar', 'Daruka Kumar', 'Hem Ismail', 'Adhita Ismail', 'Selvan Khan', 'Sachit Khan', 'Agharna Singh', 'Devaraj Ismail', 'Kalicharan Kumar', 'Pundalik Kumar', 'Chinthanaichelvan Patel', 'Aandaleeb Ismail']
Female = ['Arpana Raj', 'Jayalalita Patel', 'Lavali Jain', 'Tripurasundari Singh', 'Manana Raj', 'Gurjari Raj', 'Nivritti Ismail', 'Fullara Kumar', 'Akhila Khan', 'Sundari Khan', 'Indrakshi Khan', 'SivaSankari Jain', 'Parnashri Raj', 'Tehzeeb Kumar', 'Manushri Khan', 'Jayantika Singh', 'Chakori Raj', 'Sristi Patel', 'Yosana Ismail', 'Serena Patel', 'Anandini Raj', 'Neeharika Jain', 'Chahana Raj', 'Jayalalita Kumar', 'Shruti Kumar', 'Champabati Khan', 'Grhalakshmi Jain', 'Maithili Khan', 'Vedvalli Khan', 'Anju Patel', 'Trikaya Patel', 'Mehul Raj', 'Siddhi Khan', 'Omana Raj', 'Kana Singh', 'Abhirathi Khan', 'Aparijita Patel', 'Rubaina Kumar', 'Poorvi Singh', 'Sadhvi Patel', 'Changuna Raj', 'Ujwala Patel', 'Shatarupa Raj', 'Chaitali Kumar', 'Chandrima Kumar', 'Agrata Raj', 'Tarana Ismail', 'Sunita Ismail', 'Roshan Kumar', 'Anandita Khan', 'Nusrat Singh', 'Raksha Ismail', 'Gaurika Khan', 'Somatra Kumar', 'Valli Singh', 'Omvati Singh', 'Sucharita Patel', 'Samata Singh', 'Neeharika Khan', 'Shailaja Singh', 'Malina Khan', 'Komala Patel', 'Wamil Singh', 'Jalabala Patel', 'Umrao Khan', 'Jaladhija Kumar', 'Devasmitha Khan', 'Tatini Raj', 'Maina Kumar', 'Ruksana Singh', 'Lalima Khan', 'Labangalata Raj', 'Talikha Ismail', 'Nisha Ismail', 'Vagdevi Khan', 'Lalima Jain', 'Darshini Khan', 'Shreyashi Patel', 'Satya Kumar', 'Shree Ismail', 'Vipula Kumar', 'Gayatri Raj', 'Jagavi Jain', 'Mandakini Singh', 'Trilochana Jain', 'Advika Khan', 'Janani Singh', 'Kakali Khan', 'Sharmistha Patel', 'Manayi Jain', 'Harsha Singh', 'Januja Khan', 'Nehal Raj', 'Sukeshi Raj', 'Putul Jain', 'Suravinda Jain', 'Sonakshi Kumar', 'Putul Patel', 'Ramana Singh', 'Bhuvana Ismail', 'Ishrat Singh', 'Hirkani Ismail', 'Bindiya Singh', 'Yuthika Ismail', 'Devahuti Kumar', 'Chhabi Kumar', 'Nandini Jain', 'Kanan Kumar', 'Kundanika Patel', 'Gunitha Jain', 'Jalahasini Jain', 'Radhana Raj', 'Madhavilata Jain', 'Nandini Patel', 'Chitramala Singh', 'Vandana Patel', 'Harimanti Patel', 'Omana Patel', 'Naaz Jain', 'Narayani Jain', 'Nutan Ismail', 'Chitra Jain', 'Manik Khan', 'Madhumalati Khan', 'Kusumanjali Singh', 'Shalaka Khan', 'Suhrita Kumar', 'Iniya Ismail', 'Aboil Kumar', 'Shamita Kumar', 'Naaz Khan', 'Chameli Raj', 'Ambalika Ismail', 'Gyanada Jain', 'Firoza Singh', 'Ramya Patel', 'Ekanthika Patel', 'Tripta Jain', 'Mangai Kumar', 'Janhavi Raj', 'Ahladita Patel', 'Sumedha Ismail', 'Satyarupa Khan', 'Dwipavati Kumar', 'Kanyana Singh', 'Abhithi Jain', 'Ruchira Jain', 'Ambalika Khan', 'Ratnaprabha Khan', 'Nilavoli Jain', 'Avanti Ismail', 'Anandi Singh', 'Ihina Kumar', 'Ushma Patel', 'Urmila Kumar', 'Jayitri Ismail', 'Markandeya Ismail', 'Chakrika Raj', 'Jyotibala Kumar', 'Neelkamal Ismail', 'Geshna Jain', 'Swetha Patel', 'Shabari Jain', 'Hiranmayi Patel', 'Shrikumari Jain', 'Shishirkana Kumar', 'Charusheela Ismail', 'Aboil Ismail', 'Vatsala Jain', 'Devasree Singh', 'Tarakini Ismail', 'Suvarnaprabha Kumar', 'Maniya Raj', 'Rajanigandha Jain', 'Saheli Khan', 'Chakrika Ismail', 'Lochan Jain', 'Rachna Khan', 'Sagarika Singh', 'Sagari Raj', 'Supriti Raj', 'Rajani Raj', 'Kamya Patel', 'Kalya Singh', 'Pusti Singh', 'Kshithi Jain', 'Sanika Raj', 'Sharada Patel', 'Aaarti Raj', 'Nazima Ismail', 'Mandarmalika Raj', 'Shyamali Patel', 'Chanasya Khan', 'Sharvani Ismail', 'Vishaya Khan', 'Ankitha Khan', 'Ivy Kumar', 'Chandraja Khan', 'Arati Patel', 'Fatima Singh', 'Gurjari Patel', 'Nidhyana Singh', 'Ekantha Ismail', 'Vallari Jain', 'Sweta Jain', 'Vatsala Raj', 'Mayil Kumar', 'Girika Kumar', 'Iha Raj', 'Shulka Singh', 'Neha Kumar', 'Chetana Raj', 'Poonam Patel', 'Apsara Jain', 'Marichi Raj', 'Udita Raj', 'Vallika Raj', 'Chhaya Khan', 'Sagari Khan', 'Niyati Khan', 'Abhijna Khan', 'Suchira Khan', 'Yashoda Kumar', 'Hasumati Khan', 'Anjalika Singh', 'Phoolwati Raj', 'Aksithi Kumar', 'Tarakeshwari Raj', 'Urvasi Raj', 'Varada Ismail', 'Uthami Jain', 'Chandrabali Singh', 'Snehal Raj', 'Pradeepta Raj', 'Pankaja Ismail', 'Bani Ismail', 'Grhitha Patel', 'Sudarshana Khan', 'Apsara Patel', 'Manjubala Jain', 'Usri Patel', 'Jaishree Jain', 'Revati Khan', 'Mandra Kumar', 'Amani Jain', 'Shakuntala Raj', 'Triya Jain', 'Gaganasindhu Patel', 'Malaya Jain', 'Swati Kumar', 'Jenya Singh', 'Dhanyata Raj', 'Dalaja Khan', 'Divya Singh', 'Vedika Kumar', 'Minnoli Jain', 'Jagriti Kumar', 'Shaila Jain', 'Nileen Khan', 'Shama Raj', 'Sukanya Patel', 'Raakhi Patel', 'Purvaja Khan', 'Laksha Singh', 'Harinakshi Patel', 'Hemangi Kumar', 'Mithra Khan', 'Treya Singh', 'Sashi Khan', 'Kaushalya Patel', 'Kusumanjali Ismail', 'Somalakshmi Jain', 'Neelakshi Singh', 'Sucharita Kumar', 'Sunayana Jain', 'Pushpita Ismail', 'Ramila Khan', 'Shakuntala Patel', 'Kunjal Khan', 'Sudeepta Patel', 'Ashoka Khan', 'Dilber Kumar', 'Niral Raj', 'Sanskriti Singh', 'Siddheshwari Khan', 'Sunita Singh', 'Nalini Jain', 'Sevita Singh', 'Kalaimagal Ismail', 'Wamika Raj', 'Wamil Jain', 'Tejashree Raj', 'Yamini Singh', 'Karunya Patel', 'Ujas Patel', 'Ariktha Raj', 'Nidhyana Raj', 'Chandana Singh', 'Naganika Kumar', 'Sutapa Jain', 'Jayashree Kumar', 'Gargi Jain', 'Tanmaya Kumar', 'Medhya Ismail', 'Pritha Ismail', 'Kamadha Patel', 'Shabab Kumar', 'Nirmala Jain', 'Anuga Khan', 'Lakshmishree Patel', 'Trupti Jain', 'Shatarupa Singh', 'Jasodhara Raj', 'Keertana Raj', 'Vijayalakshmi Patel', 'Jagriti Khan', 'Suranjana Raj', 'Madhurima Raj', 'Premala Jain', 'Tamanna Khan', 'Janani Khan', 'Rachna Raj', 'Jigya Ismail', 'Mahijuba Jain', 'Chandramukhi Ismail', 'Shyamal Ismail', 'Niharika Patel', 'Aishani Khan', 'Shrivalli Ismail', 'Avanti Singh', 'Atreyi Khan', 'Adishree Patel', 'Gangotri Patel', 'Rukma Ismail', 'Subhashini Khan', 'Triyama Ismail', 'Diti Raj', 'Puloma Jain', 'Janhavi Khan', 'Putul Khan', 'Samika Kumar', 'Manjulika Kumar', 'Shyamalika Singh', 'Ambuja Ismail', 'Kiran Jain', 'Vinanti Kumar', 'Sarbani Kumar', 'Varada Kumar', 'Ishrat Kumar', 'Akuti Raj', 'Namrata Singh', 'Jayani Jain', 'Bindiya Kumar', 'Chitrarekha Jain', 'Wamika Khan', 'Gopika Raj', 'Hariganga Khan', 'Sunandita Raj', 'Pramila Singh', 'Sagari Patel', 'Chandrani Patel', 'Jamuna Ismail', 'Tanaya Patel', 'Pradeepta Singh', 'Nina Jain', 'Shevanti Kumar', 'Pritilata Patel', 'Puja Ismail', 'Manda Patel', 'Meghana Raj', 'Mehbooba Patel', 'Kahini Kumar', 'Ushma Kumar', 'Sarasvati Raj', 'Gaganadipika Ismail', 'Inayat Singh', 'Ashima Khan', 'Tamasa Jain', 'Masilmani Ismail', 'Devak Singh', 'Tamali Kumar', 'Parnik Ismail', 'Chintana Singh', 'Krishnaa Raj', 'Treya Ismail', 'Devasree Ismail', 'Ahladita Ismail', 'Kanika Singh', 'Hradha Patel', 'Vyjayanti Ismail', 'Janaki Raj', 'Lochan Raj', 'Shyamala Kumar', 'Faria Singh', 'Parveen Khan', 'Jabeen Jain', 'Elili Patel', 'Abhinithi Patel', 'Mahati Patel', 'Bandhura Kumar', 'Vanathi Jain', 'Ranjini Jain', 'Manasika Kumar', 'Padmalochana Singh', 'Jayaprada Jain', 'Neeraja Patel', 'Usri Jain', 'Manikuntala Raj', 'Shivangi Raj', 'Akuti Khan', 'Charusila Kumar', 'Nusrat Jain', 'Sasmita Raj', 'Suchi Kumar', 'Devakanya Ismail', 'Sudeepa Ismail', 'Sarojini Patel', 'Geetika Raj', 'Mahitha Jain', 'Hoor Patel', 'Neelabja Raj', 'Kasturi Khan', 'Priyasha Khan', 'Jalahasini Patel', 'Nagina Patel', 'Anahita Khan', 'Samidha Raj', 'Abhinithi Kumar', 'Mudra Patel', 'Dhanapriya Ismail', 'Ashwini Ismail', 'Vama Raj', 'Naganika Khan', 'Kunjalata Raj', 'Charulata Kumar', 'Susmita Jain', 'Kuyilsai Patel', 'Usri Singh', 'Chandratara Ismail', 'Dakshakanya Kumar', 'Shilavati Khan', 'Siddhi Kumar', 'Ehimaya Jain', 'Saudamini Singh', 'Odathi Ismail', 'Sarasa Jain', 'Padmini Khan', 'Devika Patel', 'Odathi Singh', 'Angana Ismail', 'Nila Kumar', 'Shatarupa Kumar', 'Hena Jain', 'Malashree Khan', 'Bala Khan', 'Phiroza Kumar', 'Purva Singh', 'Kajal Ismail', 'Hemanti Singh', 'Sahila Jain', 'Hiranya Jain', 'Dulari Kumar', 'Shrimayi Khan', 'Elampirai Jain', 'Vidyul Kumar', 'Samit Jain', 'Lajjawati Ismail', 'Shobhana Patel', 'Sajala Singh', 'Sudarshana Ismail', 'Maitra Khan', 'Jeevanlata Khan', 'Naseen Jain', 'Kokila Khan', 'Hemangini Singh', 'Indratha Khan', 'Diti Kumar', 'Mrinalini Khan', 'Anantya Jain', 'Jui Singh', 'Chandratara Jain', 'Sandhya Singh', 'Jayantika Patel', 'Vari Khan', 'Eshanya Khan', 'Chayana Singh', 'Ananya Khan', 'Kadambini Singh', 'Namita Patel', 'Chandrabali Jain', 'Sunandita Singh', 'Anagha Jain', 'Priyam Singh', 'Kanchana Jain', 'Arushi Raj', 'Vanaja Khan', 'Krandasi Kumar', 'Kripa Kumar', 'Ambika Kumar', 'Kalika Patel', 'Shabab Jain', 'Harsha Kumar', 'Darpana Patel', 'Ahalya Raj', 'Anjushree Kumar', 'Sudeepa Kumar', 'Sudha Patel', 'Shabalini Jain', 'Chandni Ismail', 'Samit Kumar', 'Sharadini Khan', 'Salila Raj', 'Tara Raj', 'Ashritha Jain', 'Ina Kumar', 'Ajanta Ismail', 'Urmila Jain', 'Shailaja Ismail', 'Prapti Ismail', 'Shobha Kumar', 'Jalaja Ismail', 'Madhumita Ismail', 'Keshi Raj', 'Jagrati Khan', 'Sharada Ismail', 'Neeharika Kumar', 'Sushobhana Khan', 'Soorat Singh', 'Hita Kumar', 'Sandhaya Ismail', 'Nikhita Jain', 'Jenya Patel', 'Lajwati Singh', 'Snehal Jain', 'Vanaja Jain', 'Shradhdha Kumar', 'Naaz Kumar', 'Jowaki Jain', 'Joshita Khan', 'Sphatika Kumar', 'Tannishtha Kumar', 'Apoorva Singh', 'Deepanwita Ismail', 'Tapani Raj', 'Kuvalai Singh', 'Uma Raj', 'Kimaya Ismail', 'Narayani Ismail', 'Ganga Singh', 'Aruni Jain', 'Yaalini Jain', 'Manthika Khan', 'Ipsa Singh', 'Malika Ismail', 'Hasika Jain', 'Shrabana Raj', 'Urmil Raj', 'Sarakshi Raj', 'Pakshi Singh', 'Champa Ismail', 'Aghanashini Patel', 'Ratnabali Jain', 'Fajyaz Patel', 'Manya Kumar', 'Madhushri Ismail', 'Tamasi Singh', 'Vama Ismail', 'Indrayani Jain', 'Suniti Jain', 'Ashwini Khan', 'Shyama Ismail', 'Alaknanda Raj', 'Vinoda Jain', 'Renuka Jain', 'Nidra Jain', 'Payoja Patel', 'Kajri Singh', 'Tarini Khan', 'Anya Singh', 'Sanskriti Ismail', 'Mithra Raj', 'Sudeepta Singh', 'Anurati Khan', 'Chitrita Kumar', 'Varuni Kumar', 'Dadhija Jain', 'Chadna Kumar', 'Tripti Singh', 'Kumudini Raj', 'Triyama Jain', 'Madira Raj', 'Subhuja Jain', 'Rajnandhini Kumar', 'Geeti Khan', 'Chandravathi Kumar', 'Inayat Khan', 'Chitralekha Khan', 'Ratnangi Khan', 'Nityapriya Kumar', 'Madhumita Khan', 'Naseen Singh', 'Leena Ismail', 'Ishwari Ismail', 'Narmada Jain', 'Surabhi Kumar', 'Pia Raj', 'Shashirekha Kumar', 'Malashree Jain', 'Anjali Jain', 'Jayati Kumar', 'Kavya Kumar', 'Trupti Singh', 'Shobhna Ismail', 'Suvarna Ismail', 'Mahika Ismail', 'Ojaswini Ismail', 'Renuka Ismail', 'Ramana Khan', 'Vrinda Singh', 'Rehwa Singh', 'Yuvika Ismail', 'Surupa Ismail', 'Vidula Jain', 'Ragini Ismail', 'Jenya Jain', 'Megha Khan', 'Nisha Kumar', 'Foolwati Singh', 'Agrima Singh', 'Ahladita Raj', 'Vibha Singh', 'Muthunagai Patel', 'Antara Singh', 'Swetha Khan', 'Rajeshwari Patel', 'Pakhi Khan', 'Shankhamala Singh', 'Shyamalika Jain', 'Jansi Kumar', 'Tanuka Jain', 'Tamanna Singh', 'Rajshri Raj', 'Darpanika Khan', 'Krittika Jain', 'Jayalalita Ismail', 'Sudipti Raj', 'Adrika Patel', 'Shrijani Jain', 'Sanchita Ismail', 'Fulki Khan', 'Yashila Singh', 'Mohitha Raj', 'Sangita Ismail', 'Tejal Ismail', 'Neeta Patel', 'Surotama Raj', 'Gunasundari Raj', 'Rashmika Singh', 'Kumari Raj', 'Ratna Khan', 'Unnati Jain', 'Pratibha Jain', 'Vajra Jain', 'Shabalini Raj', 'Himagouri Singh', 'Shubha Kumar', 'Rupa Khan', 'Urmil Ismail', 'Gulab Kumar', 'Eshanika Raj', 'Sugita Jain', 'Roshni Kumar', 'Kanyana Ismail', 'Inayat Ismail', 'Shuchismita Singh', 'Manjistha Jain', 'Rama Patel', 'Rajalakshmi Khan', 'Naina Ismail', 'Asvika Kumar', 'Jalanhili Kumar', 'Somatra Patel', 'Kapardini Khan', 'Saraswati Khan', 'Geeti Ismail', 'Pushpanjali Singh', 'Ujjanini Singh', 'Sangita Raj', 'Nabhanya Khan', 'Kapardini Jain', 'Antara Patel', 'Vrinda Patel', 'Kokila Patel', 'Nabhanya Patel', 'Sati Khan', 'Dayanita Raj', 'Rajnandhini Jain', 'Vasavi Khan', 'Archita Singh', 'Jayani Kumar', 'Snehalata Patel', 'Lola Patel', 'Lali Jain', 'Toral Jain', 'Shreela Singh', 'Riddhi Raj', 'Madhulika Patel', 'Sarvari Singh', 'Sukriti Khan', 'Manik Patel', 'Smriti Patel', 'Nikhita Patel', 'Manisha Jain', 'Kalika Singh', 'ThamilSelvi Ismail', 'Shinjini Patel', 'Sharmila Singh', 'Poornima Patel', 'Snigdha Kumar', 'Renu Raj', 'Hamsa Khan', 'Ikshana Kumar', 'Amla Kumar', 'Shabari Khan', 'Kanya Ismail', 'Parameshwari Khan', 'Ashwini Kumar', 'Dadhija Singh', 'Punam Khan', 'Sadhan Kumar', 'Mangalya Singh', 'Malaya Patel', 'Tejaswi Raj', 'Muskan Jain', 'Anuva Patel', 'Sadgati Patel', 'Thenral Jain', 'Roma Jain', 'Milika Ismail', 'Yajna Jain', 'Lalita Khan', 'Dhanalakshmi Raj', 'Vinita Kumar', 'Haimavati Singh', 'Anavi Jain', 'Chintanika Kumar', 'Sonali Singh', 'Krittika Singh', 'Kalpita Singh', 'Shashi Ismail', 'Usha Raj', 'Sulabha Kumar', 'Snehal Ismail', 'Lipika Singh', 'Hariganga Singh', 'Purva Jain', 'Tripurasundari Raj', 'Seerat Ismail', 'Shrigauri Raj', 'Poonam Singh', 'Sananda Patel', 'Jyotirmoyee Singh', 'Yogita Patel', 'Chandrakin Ismail', 'Nabhitha Kumar', 'Phoolwati Patel', 'Kanta Ismail', 'Yogini Raj', 'Kala Kumar', 'Chandani Ismail', 'Serena Kumar', 'Mridula Singh', 'Kusumanjali Kumar', 'Nitima Khan', 'Stuti Raj', 'Lajwanti Singh', 'Jyotibala Jain', 'Salila Khan', 'Puloma Kumar', 'Sadhya Raj', 'Aditi Ismail', 'Nidhyathi Raj', 'Chumban Raj', 'Tehzeeb Jain', 'Vahini Raj', 'Sakina Raj', 'Latika Ismail', 'Sajili Khan', 'Abhithi Khan', 'Sristi Raj', 'Aishwarya Singh', 'Vanita Khan', 'Bharati Singh', 'Sudha Kumar', 'Tuhina Raj', 'Yashawanthi Raj', 'Manjusha Khan', 'Navya Jain', 'Tapani Khan', 'Ruchi Kumar', 'Suchita Jain', 'Shukti Kumar', 'Harmya Raj', 'Thumri Singh', 'Parthivi Jain', 'Jivika Kumar', 'Preyasi Kumar', 'Karuna Patel', 'Malini Patel', 'Haimavati Jain', 'Shalaka Singh', 'Nauka Singh', 'Mudrika Khan', 'Matangi Jain', 'Mullai Ismail', 'Tvesa Raj', 'Hoor Raj', 'Mallika Raj', 'Veenapani Singh', 'Kananbala Khan', 'Vanani Singh', 'Maniya Khan', 'Ratnamala Patel', 'Tarakini Singh', 'Prabhati Jain', 'Chandrima Jain', 'Shivangi Khan', 'Arushi Singh', 'Urshita Khan', 'Medhya Khan', 'Uthami Kumar', 'Chandanika Ismail', 'Neha Ismail', 'Shirin Ismail', 'Shyamalima Ismail', 'Sarit Raj', 'Shalini Kumar', 'Preeti Jain', 'Aseema Singh', 'Anuradha Patel', 'Ishwari Khan', 'Shefalika Patel', 'Anupama Patel', 'Foolwati Jain', 'Sarvika Patel', 'Champabati Kumar', 'Hindola Patel', 'Dharitri Khan', 'Shagufta Ismail', 'Trikaya Singh', 'Ushma Jain', 'Gunitha Khan', 'Shrilata Singh', 'Sachika Patel', 'Chiti Khan', 'Sankari Khan', 'Madhuri Patel', 'Sayeeda Patel', 'Alpana Khan', 'Kanan Jain', 'Harijatha Patel', 'Sasmita Patel', 'Tarulata Ismail', 'Chitkala Jain', 'Ilampirai Ismail', 'Namrata Kumar', 'Sundha Kumar', 'Shagufta Singh', 'Deepta Jain', 'Ulupi Ismail', 'Ethaha Kumar', 'Pradnaya Patel', 'Vinaya Kumar', 'Rameshwari Ismail', 'Trinetra Singh', 'Doyel Kumar', 'Amani Ismail', 'Jayalakshmi Kumar', 'Sonika Ismail', 'Bhairavi Jain', 'Jayamala Singh', 'Janhitha Khan', 'Ratnapriya Kumar', 'Saruprani Jain', 'Padma Ismail', 'Chaitanya Ismail', 'Rukma Singh', 'Menitha Khan', 'Bakula Jain', 'Krithi Raj', 'Sadiqua Raj', 'Indu Jain', 'Nirmitha Ismail', 'Niti Patel', 'Archan Patel', 'Kusumanjali Patel', 'Dhanya Khan', 'Kandhara Khan', 'Madhu Khan', 'Urmila Singh', 'Nilasha Raj', 'Pusti Kumar', 'Govindi Ismail', 'Parinita Khan', 'Ankita Raj', 'Shravani Khan', 'Labangalata Jain', 'Shishirkana Khan', 'Vidhut Ismail', 'Madhavi Singh', 'Nimisha Raj', 'Gangika Jain', 'Shantala Kumar', 'Meghamala Singh', 'Sharmila Raj', 'Vinodini Kumar', 'Iniya Raj', 'Kuntal Jain', 'Pratigya Ismail', 'Eshanika Kumar', 'Tripuri Raj', 'Gita Khan', 'Preeti Kumar', 'Tanmaya Raj', 'Naganandini Kumar', 'Kumud Raj', 'Alka Singh', 'Rubaina Patel', 'Ikshana Jain', 'Resham Jain', 'Natun Jain', 'Suksma Ismail', 'Kalpita Khan', 'Puja Kumar', 'Damayanti Khan', 'Gargi Raj', 'Geena Khan', 'Satya Khan', 'Shyamali Ismail', 'Omvati Jain', 'Sudevi Khan', 'Kuvalai Patel', 'Akalka Kumar', 'Ekta Khan', 'Talikha Jain', 'Kaandhal Kumar', 'Vaijayantimala Kumar', 'Anandalakshmi Patel', 'Jayitri Singh', 'Mrinmayi Kumar', 'Meghamala Jain', 'Jasoda Patel', 'Haripriya Singh', 'Shankari Raj', 'Aghanashini Raj', 'Mandana Kumar', 'Ishika Patel', 'Kamana Jain', 'Jyotirmoyee Ismail', 'Suchitra Singh', 'Aradhana Kumar', 'Menaka Singh', 'Gaura Kumar', 'Aparna Kumar', 'Rupashi Kumar', 'Parama Ismail']

Blood = ["A+","A-","B+","B-","AB+","AB-","O+","O-"]
Subjects = ["English","Maths","Science","Hindi","GK"]
Schools = ["SKV Rohini","SKV Karala","SKV Begam Pur","SKV Kanhjawala","SKV Avantika"]
Student = []
Guardian = []
'''
with open("Student.csv", "w") as csv_file:
        W = csv.writer(csv_file, delimiter=',')
        for i in range(1,601):
        	Data=[]
        	Data.append(SID[i])
        	Data.append(GID[i])
        	if i%3!=0:
        		Data.append(Male[i])
        		Student.append(Male[i])
        		Data.append(str(2015-i//50)+"-0"+str(R(1,9))+"-"+str(R(11,30)))
        		Data.append("M")
        		Surname = Male[i].split()[1] 
        	else:
        		Data.append(Female[i])
        		Student.append(Female[i])
        		Data.append(str(2014-i//50)+"-0"+str(R(1,9))+"-"+str(R(11,30)))
        		Data.append("F")
        		Surname = Female[i].split()[1]
        	F = Male[R(1,500)].split()[0]+" "+Surname
        	M = Female[R(1,500)].split()[0]+" "+Surname
        	Data.append(F)
        	Guardian.append(F)
        	Data.append(M)
        	Data.append(str(min((i//50+1),12)))
        	Data.append(Schools[(i%50)//10])
        	Data.append(str(2019-i//50)+"-04-01")
        	Data.append(str(150+(i*3)//50+R(1,9)))
        	Data.append(R(40,80))
        	Data.append(random.choice(Blood))
        	if i%20==0:
        		Data.append("Yes")
        	else:
        		Data.append("No")
        	Data.append(R(40,100))
        	W.writerow(Data)

with open("Teacher.csv", "w") as csv_file:
	W = csv.writer(csv_file, delimiter=',')
	for i in range(1,301):
		Data = []
		C = 1+((i-1)%60)//5
		Q = ["E","M","H"]
		Data.append(TID[i])
		Data.append(random.choice(Female))
		Data.append(str(1980+R(1,10))+"-0"+str(R(1,9))+"-"+str(R(11,20)))
		Data.append("F")
		Data.append(Phone[i])
		Data.append(Subjects[i%5])
		Data.append(Q[(C-1)//4])
		Data.append(R(1,10))
		Data.append(Schools[(i-1)//60])
		Data.append(R(1,5))
		Data.append(C*5000)
		Data.append(C)
		W.writerow(Data)

with open("Guardian.csv", "w") as csv_file:
 	W = csv.writer(csv_file, delimiter=',')
 	for i in range(1,601):
 		Data = []
 		Data.append(GID[i])
 		Data.append(Guardian[i-1])
 		Data.append(Phone[i+350])
 		Data.append(random.choice(["Kalkaji","Okhla","Rohini","Jangpura","Greater Kailesh","Pitampura","Vasant Kunj","Vasant Vihar","Saket","Dwarka"]))
 		Data.append(ACC[i])
 		W.writerow(Data)

with open("Administration.csv", "w") as csv_file:
	W = csv.writer(csv_file, delimiter=',')
	W.writerow(["AID0000001","Mohan Lal","SKV Rohini","25000"])
	W.writerow(["AID0000002","Suresh Kumar","SKV Karala","25000"])
	W.writerow(["AID0000003","Dhanya Jain","SKV Begam Pur","25000"])
	W.writerow(["AID0000004","Mukul Aggarwal","SKV Kanhjawala","25000"])
	W.writerow(["AID0000005","Anuj Sharma","SKV Avantika","25000"])

with open("GovtOfficial.csv", "w") as csv_file:
	W = csv.writer(csv_file, delimiter=',')
	W.writerow(["GOVT000001","Rahul Sharma","Public Welfare","North","50000"])
	W.writerow(["GOVT000002","Shreya Sharma","Education","North","50000"])

with open("School.csv", "w") as csv_file:
	W = csv.writer(csv_file, delimiter=',')
	W.writerow(["SKV Rohini","Rohini","North","Shreya Jain","95"])
	W.writerow(["SKV Karala","Karala","North","Sonali Singh","85"])
	W.writerow(["SKV Begam Pur","Begam Pur","North","Akshat Pathak","90"])
	W.writerow(["SKV Kanhjawala","Kanhjawala","North","Dinesh Nanda","76"])
	W.writerow(["SKV Avantika","Avantika","North","Rishabh Jain","88"])

with open("Notice.csv", "w") as csv_file:
	W = csv.writer(csv_file, delimiter=',')
	W.writerow(["NOTICE0001","GOVT000001","2020-03-15","North","COVID19","Everyone","All schools will remain closed till 3rd May,2020 due to COVID19."])
	W.writerow(["NOTICE0002","GOVT000002","2020-03-30","North","COVID19","Students","Students are requested to attend online classes. Stay Safe."])

with open("Exams.csv", "w") as csv_file:
	W = csv.writer(csv_file, delimiter=',')
	for i in range(60):
		Data = []
		C = i//5+1
		S = Subjects[i%5]
		Data.append("EXAM000"+S[0]+str(C+10))
		Data.append(C)
		Data.append(S)
		Data.append("2020-03-0"+str(i%5+1))
		W.writerow(Data)

with open("Assignments.csv", "w") as csv_file:
	W = csv.writer(csv_file, delimiter=',')
	for j in range(4):
		for i in range(1,301):
			Data = []
			C = 1+((i-1)%60)//5
			S = Subjects[i%5]
			A = Schools[(i-1)//60]
			Data.append("ASSIG"+str((i-1)//60)+str(j)+S[0]+str(10+C))
			Data.append(TID[i])
			Data.append(C)
			Data.append(S)
			Data.append(A)
			Data.append("2020"+"-0"+str(R(1,9))+"-"+str(R(11,20)))
			Data.append(0)
			Data.append("Complete and submit by the deadline.")
			W.writerow(Data)

with open("Grades.csv", "w") as csv_file:
	W = csv.writer(csv_file, delimiter=',')
	for j in range(5):
		for i in range(1,601):
			Data = []
			C = min((i//50+1),12)
			Data.append(SID[i])
			Data.append("EXAM000"+Subjects[j][0]+str(C+10))
			Data.append(R(20,100))
			W.writerow(Data)

with open("Submissions.csv", "w") as csv_file:
	W = csv.writer(csv_file, delimiter=',')
	for k in range(4):
		for j in range(5):
			for i in range(1,601):
				C = min((i//50+1),12)
				A = "ASSIG0"+str(k)+Subjects[j][0]+str(10+C)
				I = SID[i]
				if R(0,1)==1:
					W.writerow([I,A])
'''
with open("SubjectInfo.csv", "w") as csv_file:
	W = csv.writer(csv_file, delimiter=',')
	for k in range(5):
		for i in range(1,13):
			for j in range(5):
				Data = []
				Data.append(i)
				Data.append(Subjects[j])
				Data.append("NCERT "+Subjects[j]+"-"+str(i))
				Data.append(4)
				Data.append(1)
				Data.append(Schools[k])
				W.writerow(Data)
'''
with open ("Attendance.csv", "w") as csv_file:
	W = csv.writer(csv_file, delimiter=',')
	for i in range(1,32):
		if i not in [1,8,15,22,29,7,14,21,28]:
			D = "2020-03-"+"0"*(2-len(str(i)))+str(i)
			for j in range(1,601):
				if R(1,10)<7:
					W.writerow([SID[j],D])

with open ("FeeDetails.csv", "w") as csv_file:
	W = csv.writer(csv_file, delimiter=',')
	for i in range(1,601):
		if R(1,3)<3:
			S = "Paid"
		else:
			S = "Due"
		W.writerow([PID[i],GID[i],SID[i],"2020-02-25","4",S])

print("Data Generation Succesful :)")
'''