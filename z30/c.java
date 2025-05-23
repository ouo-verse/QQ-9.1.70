package z30;

import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.album.view.QFSPersonalAlbumDetailWidget;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends com.tencent.biz.qqcircle.bizparts.c {
    public static final String D = "z30.c";
    private QFSPersonalAlbumDetailWidget C;

    public c(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        if (this.C == null) {
            this.C = new QFSPersonalAlbumDetailWidget(viewGroup.getContext(), (QCircleBaseFragment) getParentFragment(), this);
        }
        return this.C;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    protected String getLogTag() {
        return D;
    }

    public void i0(UIStateData<List<e30.b>> uIStateData) {
        QFSPersonalAlbumDetailWidget qFSPersonalAlbumDetailWidget = this.C;
        if (qFSPersonalAlbumDetailWidget != null) {
            qFSPersonalAlbumDetailWidget.z0(uIStateData);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
