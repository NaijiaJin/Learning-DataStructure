package creatures;

import huglife.Creature;
import huglife.Direction;
import huglife.Occupant;
import huglife.Action;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

import java.awt.Color;
import static huglife.HugLifeUtils.randomEntry;

public class Clorus extends Creature {

    private int r;
    private int g;
    private int b;

    private double energyRetained=0.5;
    private double energyGiven=0.5;
    private double moveProbability=0;

    public Clorus(double e)
    {
        super("clorus");
        r=0;
        b=0;
        g=0;
        energy=e;
    }

    public Clorus()
    {
        this(1);
    }

    public Color color()
    {
        g=0;
        r=34;
        b=231;
        return color(r,g,b);
    }

    public void move()
    {
        energy-=0.03;


    }
    public void stay()
    {
        energy-=0.01;
    }

    public void attack(Creature c)
    {
        energy=c.energy();
    }

    public Clorus replicate()
    {
        double babyclorusEnergy=energy*energyGiven;
        energy=energy*energyRetained;
        return new Clorus(babyclorusEnergy);
    }

    public Action chooseAction(Map<Direction, Occupant> neighbors)
    {
        Deque<Direction> emptyNeighbors =new ArrayDeque<>();
        boolean anyPlip=false;
        Deque<Direction> plipNeighbors=new ArrayDeque<>();

        for(Direction dir:neighbors.keySet())
        {
            if(neighbors.get(dir).name().equals("empty"))
            {
                emptyNeighbors.addLast(dir);
            }
            else if(neighbors.get(dir).name().equals("plip"))
            {
                anyPlip=true;
                plipNeighbors.addLast(dir);
            }
        }

        if((emptyNeighbors.size()==0)&&(anyPlip==false))
        {
            return new Action(Action.ActionType.STAY);
        }
        else if (anyPlip)
        {
            return new Action(Action.ActionType.ATTACK,randomEntry(plipNeighbors));
        }
        else if (energy>=1)
        {
            return new Action(Action.ActionType.REPLICATE,randomEntry(emptyNeighbors));
        }
        else
        {
            return new Action(Action.ActionType.MOVE,randomEntry(emptyNeighbors));
        }

    }
}
