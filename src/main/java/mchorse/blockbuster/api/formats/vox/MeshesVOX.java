package mchorse.blockbuster.api.formats.vox;

import mchorse.blockbuster.api.Model;
import mchorse.blockbuster.api.ModelLimb;
import mchorse.blockbuster.api.ModelTransform;
import mchorse.blockbuster.api.formats.IMeshes;
import mchorse.blockbuster.api.formats.Mesh;
import mchorse.blockbuster.client.model.ModelCustomRenderer;
import mchorse.blockbuster.client.model.ModelVoxRenderer;
import net.minecraft.client.model.ModelBase;

public class MeshesVOX implements IMeshes
{
	public Mesh mesh;
	public Vox vox;

	@Override
	public ModelCustomRenderer createRenderer(Model data, ModelBase model, ModelLimb limb, ModelTransform transform)
	{
		return new ModelVoxRenderer(model, limb, transform, this);
	}
}