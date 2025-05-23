package tencent.im.oidb.ranklist_comm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ranklist_comm$RankItem extends MessageMicro<ranklist_comm$RankItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"nick", "figure", "value", "rank"}, new Object[]{"", "", 0, 0}, ranklist_comm$RankItem.class);
    public final PBStringField nick = PBField.initString("");
    public final PBStringField figure = PBField.initString("");
    public final PBInt32Field value = PBField.initInt32(0);
    public final PBInt32Field rank = PBField.initInt32(0);
}
