package tencent.im.oidb.cmd0xae9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_online_docs$DocInfo extends MessageMicro<group_online_docs$DocInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50}, new String[]{"doc_meta_data", "creator_nick", "owner_nick", "last_modify_nick", "top", "doc_url"}, new Object[]{null, "", "", "", 0, ""}, group_online_docs$DocInfo.class);
    public online_docs$DocMetaData doc_meta_data = new online_docs$DocMetaData();
    public final PBStringField creator_nick = PBField.initString("");
    public final PBStringField owner_nick = PBField.initString("");
    public final PBStringField last_modify_nick = PBField.initString("");
    public final PBUInt32Field top = PBField.initUInt32(0);
    public final PBStringField doc_url = PBField.initString("");
}
