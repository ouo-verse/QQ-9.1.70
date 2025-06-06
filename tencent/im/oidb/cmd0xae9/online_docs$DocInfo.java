package tencent.im.oidb.cmd0xae9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class online_docs$DocInfo extends MessageMicro<online_docs$DocInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 56, 64, 72, 80, 90, 98, 106, 114, 122, 130}, new String[]{"doc_meta", "creator_nick", "owner_nick", "last_modify_nick", "is_pinned", "doc_url", "doc_policy", "last_browse_ts", "last_pinned_ts", "browse_del_ts", "pin_doc_url", "unpin_doc_url", "delete_doc_url", "change_title_url", "export_url", "last_editor_head_url"}, new Object[]{null, "", "", "", Boolean.FALSE, "", 0, 0, 0, 0, "", "", "", "", "", ""}, online_docs$DocInfo.class);
    public online_docs$DocMetaData doc_meta = new online_docs$DocMetaData();
    public final PBStringField creator_nick = PBField.initString("");
    public final PBStringField owner_nick = PBField.initString("");
    public final PBStringField last_modify_nick = PBField.initString("");
    public final PBBoolField is_pinned = PBField.initBool(false);
    public final PBStringField doc_url = PBField.initString("");
    public final PBUInt32Field doc_policy = PBField.initUInt32(0);
    public final PBUInt32Field last_browse_ts = PBField.initUInt32(0);
    public final PBUInt32Field last_pinned_ts = PBField.initUInt32(0);
    public final PBUInt32Field browse_del_ts = PBField.initUInt32(0);
    public final PBStringField pin_doc_url = PBField.initString("");
    public final PBStringField unpin_doc_url = PBField.initString("");
    public final PBStringField delete_doc_url = PBField.initString("");
    public final PBStringField change_title_url = PBField.initString("");
    public final PBStringField export_url = PBField.initString("");
    public final PBStringField last_editor_head_url = PBField.initString("");
}
