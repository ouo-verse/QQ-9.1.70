package tencent.im.troop.flock;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QeventPB$Feed extends MessageMicro<QeventPB$Feed> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField cover_url;
    public final PBUInt32Field group_status;
    public final PBBytesField join_group_authsig;
    public final PBBytesField recom_trace;
    public final PBRepeatMessageField<QeventPB$FeedTagInfo> tag_infos;

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f436058id = PBField.initString("");
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBUInt64Field from_group_id = PBField.initUInt64(0);
    public QeventPB$User publisher = new QeventPB$User();
    public final PBEnumField type = PBField.initEnum(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBUInt64Field create_time = PBField.initUInt64(0);
    public QeventPB$ActivityTime activity_time = new QeventPB$ActivityTime();
    public final PBRepeatMessageField<QeventPB$Image> images = PBField.initRepeatMessage(QeventPB$Image.class);
    public QeventPB$PoiInfo poi_info = new QeventPB$PoiInfo();
    public QeventPB$FeedRight right = new QeventPB$FeedRight();
    public QeventPB$FeedOpInfo op_info = new QeventPB$FeedOpInfo();
    public QeventPB$JoinInfo join_info = new QeventPB$JoinInfo();
    public QeventPB$SecurityReportInfo secuirty_report_info = new QeventPB$SecurityReportInfo();

    static {
        String[] strArr = {"id", "group_id", "from_group_id", "publisher", "type", "title", "content", AlbumCacheData.CREATE_TIME, "activity_time", "images", "poi_info", "right", "op_info", "join_info", "secuirty_report_info", "join_group_authsig", "group_status", "tag_infos", "cover_url", "recom_trace"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 50, 58, 64, 74, 82, 90, 98, 106, 114, 122, 130, 136, 146, 154, 98762}, strArr, new Object[]{"", 0L, 0L, null, 0, "", "", 0L, null, null, null, null, null, null, null, byteStringMicro, 0, null, "", byteStringMicro}, QeventPB$Feed.class);
    }

    public QeventPB$Feed() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.join_group_authsig = PBField.initBytes(byteStringMicro);
        this.group_status = PBField.initUInt32(0);
        this.tag_infos = PBField.initRepeatMessage(QeventPB$FeedTagInfo.class);
        this.cover_url = PBField.initString("");
        this.recom_trace = PBField.initBytes(byteStringMicro);
    }
}
