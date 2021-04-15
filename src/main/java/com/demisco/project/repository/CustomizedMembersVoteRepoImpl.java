package com.demisco.project.repository;

import com.demisco.project.exception.InvalidVoteException;
import com.demisco.project.model.MembersVote;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.*;

public class CustomizedMembersVoteRepoImpl implements CustomizedMembersVoteRepo {
    //Validation: Each User Can Vote for Only One Genre Per Month
    @Override
    public void memberVoteValidate(List<MembersVote> membersVotes) {
        for (MembersVote m : membersVotes) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(m.getVoteDate());
            calendar.add(Calendar.MONTH, 1);
            Date date = new Date(new java.util.Date().getTime());
            if (calendar.getTime().after(date)) {
                String expireDate = new SimpleDateFormat("dd.MM.yyyy").format(calendar.getTime());
                throw new InvalidVoteException(expireDate);
            }
        }
    }
}