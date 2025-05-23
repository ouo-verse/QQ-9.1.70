package tencent.im.oidb.cmd0xb85;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tencent.im.oidb.ranklist_comm.ranklist_comm$RankItem;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xb85$GetRankListRspBody extends MessageMicro<Oidb_0xb85$GetRankListRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"rpt_rank_item", "self_rank_item"}, new Object[]{null, null}, Oidb_0xb85$GetRankListRspBody.class);
    public final PBRepeatMessageField<ranklist_comm$RankItem> rpt_rank_item = PBField.initRepeatMessage(ranklist_comm$RankItem.class);
    public ranklist_comm$RankItem self_rank_item = new ranklist_comm$RankItem();
}
