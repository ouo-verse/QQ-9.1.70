package tencent.im.oidb.inner.cmdGroupAdGetAdInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetTroopAioTopAD$AdInfo extends MessageMicro<GetTroopAioTopAD$AdInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 58}, new String[]{"uint32_ad_id", "str_background_url", "str_more_url", "str_pic_url", "uint32_valid_interval", QAdVrReportParams.ParamKey.AD_SHOW_TYPE, "msg_ext_adinfo"}, new Object[]{0, "", "", "", 0, 0, null}, GetTroopAioTopAD$AdInfo.class);
    public final PBUInt32Field uint32_ad_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_valid_interval = PBField.initUInt32(0);
    public final PBStringField str_background_url = PBField.initString("");
    public final PBStringField str_more_url = PBField.initString("");
    public final PBStringField str_pic_url = PBField.initString("");
    public final PBEnumField ad_show_type = PBField.initEnum(0);
    public GetTroopAioTopAD$ExtAdInfo msg_ext_adinfo = new MessageMicro<GetTroopAioTopAD$ExtAdInfo>() { // from class: tencent.im.oidb.inner.cmdGroupAdGetAdInfo.GetTroopAioTopAD$ExtAdInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"str_word", "str_ui_url", "str_jmp_url"}, new Object[]{"", "", ""}, GetTroopAioTopAD$ExtAdInfo.class);
        public final PBStringField str_word = PBField.initString("");
        public final PBStringField str_ui_url = PBField.initString("");
        public final PBStringField str_jmp_url = PBField.initString("");
    };
}
