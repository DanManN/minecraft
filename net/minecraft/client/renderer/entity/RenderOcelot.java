package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderOcelot extends RenderLiving
{
    private static final ResourceLocation field_110877_a = new ResourceLocation("textures/entity/cat/black.png");
    private static final ResourceLocation field_110875_f = new ResourceLocation("textures/entity/cat/ocelot.png");
    private static final ResourceLocation field_110876_g = new ResourceLocation("textures/entity/cat/red.png");
    private static final ResourceLocation field_110878_h = new ResourceLocation("textures/entity/cat/siamese.png");

    public RenderOcelot(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }

    public void renderLivingOcelot(EntityOcelot par1EntityOcelot, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1EntityOcelot, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation func_110874_a(EntityOcelot par1EntityOcelot)
    {
        switch (par1EntityOcelot.getTameSkin())
        {
            case 0:
            default:
                return field_110875_f;
            case 1:
                return field_110877_a;
            case 2:
                return field_110876_g;
            case 3:
                return field_110878_h;
        }
    }

    /**
     * Pre-Renders the Ocelot.
     */
    protected void preRenderOcelot(EntityOcelot par1EntityOcelot, float par2)
    {
        super.preRenderCallback(par1EntityOcelot, par2);

        if (par1EntityOcelot.isTamed())
        {
            GL11.glScalef(0.8F, 0.8F, 0.8F);
        }
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderLivingOcelot((EntityOcelot)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.preRenderOcelot((EntityOcelot)par1EntityLivingBase, par2);
    }

    public void renderPlayer(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderLivingOcelot((EntityOcelot)par1EntityLivingBase, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation func_110775_a(Entity par1Entity)
    {
        return this.func_110874_a((EntityOcelot)par1Entity);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderLivingOcelot((EntityOcelot)par1Entity, par2, par4, par6, par8, par9);
    }
}
