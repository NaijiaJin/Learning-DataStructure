public class sphereIntersection {

    public String[] ray_sphere_intersect (float[] sphere_center, float sphere_radius, float[] ray_origin, float[] ray_dir) {
        // write code here
        float[] center_to_ray = new float[3];
        float op1=0;
        float length_of_pp=0;
        float[] p1p2= new float[3];
        float[] projection_of_op1= new float[3];
        float length_of_p=0;
        String[] result= new String[2];
        for(int i=0;i<3;i++)
        {
            center_to_ray[i]=ray_origin[i]-sphere_center[i];
            op1+=center_to_ray[i]*center_to_ray[i];
            p1p2[i]=ray_dir[i]-ray_origin[i];

            length_of_pp += (p1p2[i])*(p1p2[i]);

            projection_of_op1[i]= p1p2[i]*center_to_ray[i];
            length_of_p=(projection_of_op1[i])*(projection_of_op1[i]);
        }

        double d = 0;
        d=Math.sqrt((op1)-(length_of_p));
        if(d>sphere_radius)
        {
            for(int i=0;i<2;i++)
            {
                result[i]="Null";
            }
            return result;
        }
        else if (d==sphere_radius)
        {
            double[] oneintersection= new double [3];
            for(int i=0;i<3;i++)
            {
                oneintersection[i]=ray_origin[i]+Math.sqrt(length_of_p);
            }
            result[0]=oneintersection.toString();
            result[1]="Null";
            return result;
        }
        else{
            return result;
        }






    }

    public void main(String[] args) {
        float[] sphere_center=[0,0,0];
        float sphere_radius=1;
        float[] ray_origin=[1.25,0.616,-0.355];
        float[] ray_dir= [-4.49E-01,-0.189,0.38];
        ray_sphere_intersect (sphere_center, sphere_radius,  ray_origin,  ray_dir);
    }
}
