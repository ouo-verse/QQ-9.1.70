package tencent.im.oidb.guild_search_recommend_svr;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class guildSearchRecommendSvr$GetRecommendGroupReq extends MessageMicro<guildSearchRecommendSvr$GetRecommendGroupReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField class_name;
    public final PBBytesField class_param;
    public final PBBoolField first_show;
    public final PBUInt32Field is_new;
    public final PBBytesField session_info;
    public final PBUInt32Field style_type;
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBUInt32Field pos = PBField.initUInt32(0);
    public guildSearchRecommendSvr$GPS msg_gps = new MessageMicro<guildSearchRecommendSvr$GPS>() { // from class: tencent.im.oidb.guild_search_recommend_svr.guildSearchRecommendSvr$GPS
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 66, 72}, new String[]{"latitude", "longitude", "altitude", "accuracy", "time", "flag", "cityid", "client_version", "client"}, new Object[]{0, 0, 0, 0, 0, 0, 0, ByteStringMicro.EMPTY, 0}, guildSearchRecommendSvr$GPS.class);
        public final PBUInt32Field latitude = PBField.initUInt32(0);
        public final PBUInt32Field longitude = PBField.initUInt32(0);
        public final PBUInt32Field altitude = PBField.initUInt32(0);
        public final PBUInt32Field accuracy = PBField.initUInt32(0);
        public final PBUInt32Field time = PBField.initUInt32(0);
        public final PBUInt32Field flag = PBField.initUInt32(0);
        public final PBUInt32Field cityid = PBField.initUInt32(0);
        public final PBBytesField client_version = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field client = PBField.initUInt32(0);
    };

    static {
        String[] strArr = {"appid", c.G, "msg_gps", "class_param", PictureConst.KEY_CLASSNAME, "is_new", AppConstants.Key.SESSION_INFO, "style_type", "first_show"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48, 58, 64, 72}, strArr, new Object[]{0, 0, null, byteStringMicro, "", 0, byteStringMicro, 0, Boolean.FALSE}, guildSearchRecommendSvr$GetRecommendGroupReq.class);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [tencent.im.oidb.guild_search_recommend_svr.guildSearchRecommendSvr$GPS] */
    public guildSearchRecommendSvr$GetRecommendGroupReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.class_param = PBField.initBytes(byteStringMicro);
        this.class_name = PBField.initString("");
        this.is_new = PBField.initUInt32(0);
        this.session_info = PBField.initBytes(byteStringMicro);
        this.style_type = PBField.initUInt32(0);
        this.first_show = PBField.initBool(false);
    }
}
