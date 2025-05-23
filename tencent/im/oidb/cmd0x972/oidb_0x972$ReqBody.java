package tencent.im.oidb.cmd0x972;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.weiyun.poi.PoiDbManager;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x972$ReqBody extends MessageMicro<oidb_0x972$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field boold_type;
    public final PBInt32Field career_id;
    public final PBBytesField check_nick;
    public final PBInt32Field city_id;
    public final PBInt32Field constellation;
    public final PBInt32Field country_id;
    public final PBInt32Field end_age;
    public oidb_0x972$ExtensionRequestInfo extension_request_info;
    public final PBInt32Field gander;
    public final PBInt32Field h_city_id;
    public final PBInt32Field h_country_id;
    public final PBInt32Field h_province_id;
    public final PBBytesField key_word;
    public final PBInt32Field online;
    public final PBInt32Field province_id;
    public oidb_0x972$RootSearcherRequest search_request;
    public final PBInt32Field start_age;
    public final PBBytesField version;
    public final PBInt32Field video;

    static {
        String[] strArr = {QCircleSchemeAttr.Detail.KEY_WORD, "version", "search_request", "gander", "start_age", "end_age", LpReport_UserInfo_dc02148.CONSTELLATION, "boold_type", "country_id", "province_id", PoiDbManager.COL_POI_CITY_ID, "h_country_id", "h_province_id", "h_city_id", "career_id", TPReportKeys.Common.COMMON_ONLINE, "video", "extension_request_info", "check_nick"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 80, 88, 96, 104, 112, 120, 128, 136, 144, 152, 160, 168, 176, 184, 802, 810}, strArr, new Object[]{byteStringMicro, byteStringMicro, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, byteStringMicro}, oidb_0x972$ReqBody.class);
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [tencent.im.oidb.cmd0x972.oidb_0x972$ExtensionRequestInfo] */
    public oidb_0x972$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.key_word = PBField.initBytes(byteStringMicro);
        this.version = PBField.initBytes(byteStringMicro);
        this.search_request = new oidb_0x972$RootSearcherRequest();
        this.gander = PBField.initInt32(0);
        this.start_age = PBField.initInt32(0);
        this.end_age = PBField.initInt32(0);
        this.constellation = PBField.initInt32(0);
        this.boold_type = PBField.initInt32(0);
        this.country_id = PBField.initInt32(0);
        this.province_id = PBField.initInt32(0);
        this.city_id = PBField.initInt32(0);
        this.h_country_id = PBField.initInt32(0);
        this.h_province_id = PBField.initInt32(0);
        this.h_city_id = PBField.initInt32(0);
        this.career_id = PBField.initInt32(0);
        this.online = PBField.initInt32(0);
        this.video = PBField.initInt32(0);
        this.extension_request_info = new MessageMicro<oidb_0x972$ExtensionRequestInfo>() { // from class: tencent.im.oidb.cmd0x972.oidb_0x972$ExtensionRequestInfo
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField action;
            public final PBBytesField city;
            public final PBFloatField latitude;
            public final PBFloatField longitude;
            public final PBInt32Field radius;
            public final PBBytesField region;

            static {
                String[] strArr = {"action", "latitude", "longitude", "radius", "city", TtmlNode.TAG_REGION};
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                Float valueOf = Float.valueOf(0.0f);
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 21, 29, 32, 42, 50}, strArr, new Object[]{byteStringMicro2, valueOf, valueOf, 0, byteStringMicro2, byteStringMicro2}, oidb_0x972$ExtensionRequestInfo.class);
            }

            {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                this.action = PBField.initBytes(byteStringMicro2);
                this.latitude = PBField.initFloat(0.0f);
                this.longitude = PBField.initFloat(0.0f);
                this.radius = PBField.initInt32(0);
                this.city = PBField.initBytes(byteStringMicro2);
                this.region = PBField.initBytes(byteStringMicro2);
            }
        };
        this.check_nick = PBField.initBytes(byteStringMicro);
    }
}
