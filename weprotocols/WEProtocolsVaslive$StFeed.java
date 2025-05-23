package weprotocols;

import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;

/* loaded from: classes30.dex */
public final class WEProtocolsVaslive$StFeed extends MessageMicro<WEProtocolsVaslive$StFeed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 34, 42, 64, 208, 402}, new String[]{"id", QAdVrReport.ElementID.AD_POSTER, "cover", "type", "feedType", "live"}, new Object[]{"", null, null, 0, 0, null}, WEProtocolsVaslive$StFeed.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f445553id = PBField.initString("");
    public WEProtocolsVaslive$StUser poster = new MessageMicro<WEProtocolsVaslive$StUser>() { // from class: weprotocols.WEProtocolsVaslive$StUser
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 162}, new String[]{"id", "nick", "thirdId"}, new Object[]{"", "", ""}, WEProtocolsVaslive$StUser.class);

        /* renamed from: id, reason: collision with root package name */
        public final PBStringField f445554id = PBField.initString("");
        public final PBStringField nick = PBField.initString("");
        public final PBStringField thirdId = PBField.initString("");
    };
    public WEProtocolsVaslive$StImage cover = new MessageMicro<WEProtocolsVaslive$StImage>() { // from class: weprotocols.WEProtocolsVaslive$StImage
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 42, 50}, new String[]{"width", "height", "picUrl", "picId", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA}, new Object[]{0, 0, "", "", ByteStringMicro.EMPTY}, WEProtocolsVaslive$StImage.class);
        public final PBUInt32Field width = PBField.initUInt32(0);
        public final PBUInt32Field height = PBField.initUInt32(0);
        public final PBStringField picUrl = PBField.initString("");
        public final PBStringField picId = PBField.initString("");
        public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field feedType = PBField.initUInt32(0);
    public WEProtocolsVaslive$StLive live = new MessageMicro<WEProtocolsVaslive$StLive>() { // from class: weprotocols.WEProtocolsVaslive$StLive
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{QZoneDTLoginReporter.SCHEMA, "room", "liveExtInfo"}, new Object[]{"", null, null}, WEProtocolsVaslive$StLive.class);
        public final PBStringField schema = PBField.initString("");
        public WEProtocolsVaslive$RoomInfoData room = new MessageMicro<WEProtocolsVaslive$RoomInfoData>() { // from class: weprotocols.WEProtocolsVaslive$RoomInfoData
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 58, 64, 74, 80}, new String[]{"roomId", "roomTitle", "rtmpUrl", "topic", "roomState", "roomType", "coverUrl", "source", "flvUrl", "isUseFlvUrl"}, new Object[]{0L, "", "", "", 0, 0, "", 0L, "", Boolean.FALSE}, WEProtocolsVaslive$RoomInfoData.class);
            public final PBUInt64Field roomId = PBField.initUInt64(0);
            public final PBStringField roomTitle = PBField.initString("");
            public final PBStringField rtmpUrl = PBField.initString("");
            public final PBStringField topic = PBField.initString("");
            public final PBUInt32Field roomState = PBField.initUInt32(0);
            public final PBUInt32Field roomType = PBField.initUInt32(0);
            public final PBStringField coverUrl = PBField.initString("");
            public final PBUInt64Field source = PBField.initUInt64(0);
            public final PBStringField flvUrl = PBField.initString("");
            public final PBBoolField isUseFlvUrl = PBField.initBool(false);
        };
        public final PBRepeatMessageField<WEProtocolsVaslive$Entry> liveExtInfo = PBField.initRepeatMessage(WEProtocolsVaslive$Entry.class);
    };
}
