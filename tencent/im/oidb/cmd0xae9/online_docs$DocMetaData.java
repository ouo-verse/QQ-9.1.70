package tencent.im.oidb.cmd0xae9;

import com.qzone.album.data.model.PhotoCacheData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class online_docs$DocMetaData extends MessageMicro<online_docs$DocMetaData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 114, 122, 130, 138}, new String[]{"doc_id", "title", "creator_uin", "create_ts", "last_modify_uin", "last_modify_ts", PhotoCacheData.OWNER_UIN, "doc_type", "creator_uid", "last_modify_uid", "owner_uid", "doc_status", "status_change_ts", "doc_icon", "doc_type_desc", "doc_thumbnail", "short_url"}, new Object[]{null, ByteStringMicro.EMPTY, 0L, 0, 0L, 0, 0L, 0, 0L, 0L, 0L, 0, 0, "", "", "", ""}, online_docs$DocMetaData.class);
    public online_docs$DocId doc_id = new online_docs$DocId();
    public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field creator_uin = PBField.initUInt64(0);
    public final PBUInt32Field create_ts = PBField.initUInt32(0);
    public final PBUInt64Field last_modify_uin = PBField.initUInt64(0);
    public final PBUInt32Field last_modify_ts = PBField.initUInt32(0);
    public final PBUInt64Field owner_uin = PBField.initUInt64(0);
    public final PBUInt32Field doc_type = PBField.initUInt32(0);
    public final PBUInt64Field creator_uid = PBField.initUInt64(0);
    public final PBUInt64Field last_modify_uid = PBField.initUInt64(0);
    public final PBUInt64Field owner_uid = PBField.initUInt64(0);
    public final PBUInt32Field doc_status = PBField.initUInt32(0);
    public final PBUInt32Field status_change_ts = PBField.initUInt32(0);
    public final PBStringField doc_icon = PBField.initString("");
    public final PBStringField doc_type_desc = PBField.initString("");
    public final PBStringField doc_thumbnail = PBField.initString("");
    public final PBStringField short_url = PBField.initString("");
}
