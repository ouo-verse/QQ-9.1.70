package tencent.im.oidb.cmd0xae9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class online_docs$DocListItem extends MessageMicro<online_docs$DocListItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40}, new String[]{"doc_id", "is_pinned", "pin_ts", "order_ts", "browse_del_ts"}, new Object[]{null, Boolean.FALSE, 0, 0, 0}, online_docs$DocListItem.class);
    public online_docs$DocId doc_id = new online_docs$DocId();
    public final PBBoolField is_pinned = PBField.initBool(false);
    public final PBUInt32Field pin_ts = PBField.initUInt32(0);
    public final PBUInt32Field order_ts = PBField.initUInt32(0);
    public final PBUInt32Field browse_del_ts = PBField.initUInt32(0);
}
