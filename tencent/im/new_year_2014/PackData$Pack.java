package tencent.im.new_year_2014;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.tmassistantbase.util.GlobalUtil;

/* loaded from: classes29.dex */
public final class PackData$Pack extends MessageMicro<PackData$Pack> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field appid;
    public final PBUInt32Field business;
    public final PBUInt32Field ctime;
    public final PBBoolField empty;
    public final PBUInt32Field etime;
    public final PBBoolField expired;
    public final PBUInt32Field group_id;
    public final PBUInt32Field group_type;
    public final PBBoolField locked;
    public final PBUInt32Field money;
    public final PBUInt32Field mtime;
    public final PBStringField order;
    public final PBBytesField pack_id;
    public final PBStringField peer_face;
    public final PBBytesField peer_nick;
    public final PBUInt64Field peer_uin;
    public final PBUInt32Field promotion_id;
    public final PBBoolField provider_dead;
    public final PBBytesField signature;
    public final PBUInt32Field state;
    public final PBUInt32Field type;
    public final PBUInt64Field uin;
    public final PBStringField url;
    public final PBUInt32Field user_apn;
    public final PBStringField user_ip;

    static {
        String[] strArr = {"pack_id", "state", "type", "ctime", WidgetCacheConstellationData.MONEY, "business", "signature", "url", ProtocolDownloaderConstants.HEADER_FRIEND_UIN, TPReportKeys.PlayerStep.PLAYER_END_TIME, "peer_nick", "expired", "locked", "order", "peer_face", "uin", "group_type", "group_id", "promotion_id", "user_ip", "user_apn", GlobalUtil.DEF_STRING, "appid", "provider_dead", "mtime"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 58, 66, 72, 80, 90, 96, 104, 114, 122, 128, 136, 144, 152, 162, 168, 176, 184, 192, 200}, strArr, new Object[]{byteStringMicro, 0, 0, 0, 0, 0, byteStringMicro, "", 0L, 0, byteStringMicro, bool, bool, "", "", 0L, 0, 0, 0, "", 0, bool, 0, bool, 0}, PackData$Pack.class);
    }

    public PackData$Pack() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.pack_id = PBField.initBytes(byteStringMicro);
        this.state = PBField.initUInt32(0);
        this.type = PBField.initUInt32(0);
        this.ctime = PBField.initUInt32(0);
        this.money = PBField.initUInt32(0);
        this.business = PBField.initUInt32(0);
        this.signature = PBField.initBytes(byteStringMicro);
        this.url = PBField.initString("");
        this.peer_uin = PBField.initUInt64(0L);
        this.etime = PBField.initUInt32(0);
        this.peer_nick = PBField.initBytes(byteStringMicro);
        this.expired = PBField.initBool(false);
        this.locked = PBField.initBool(false);
        this.order = PBField.initString("");
        this.peer_face = PBField.initString("");
        this.uin = PBField.initUInt64(0L);
        this.group_type = PBField.initUInt32(0);
        this.group_id = PBField.initUInt32(0);
        this.promotion_id = PBField.initUInt32(0);
        this.user_ip = PBField.initString("");
        this.user_apn = PBField.initUInt32(0);
        this.empty = PBField.initBool(false);
        this.appid = PBField.initUInt32(0);
        this.provider_dead = PBField.initBool(false);
        this.mtime = PBField.initUInt32(0);
    }
}
