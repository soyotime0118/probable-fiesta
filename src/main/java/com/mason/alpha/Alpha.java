package com.mason.alpha;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import java.sql.SQLException;

public class Alpha
{
    public static void main(String[] args)
    {
        Cars cars = new Cars();
        try
        {
            cars.updateData();
        }
        catch (SystemException e)
        {
            e.printStackTrace();
        }
        catch (HeuristicRollbackException e)
        {
            e.printStackTrace();
        }
        catch (HeuristicMixedException e)
        {
            e.printStackTrace();
        }
        catch (RollbackException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
