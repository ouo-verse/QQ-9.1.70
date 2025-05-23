package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tenpay.realname.RealNameSource;

/* loaded from: classes29.dex */
public final class QQGameSubscribe$ShareArkParam extends MessageMicro<QQGameSubscribe$ShareArkParam> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 26, 34, 42, 50, 58}, new String[]{"app", "view", "ver", "prompt", DownloadInfo.spKey_Config, RealNameSource.EXTRA_KEY_SOURCE_NAME}, new Object[]{"", "", "", "", null, ""}, QQGameSubscribe$ShareArkParam.class);
    public final PBStringField app = PBField.initString("");
    public final PBStringField view = PBField.initString("");
    public final PBStringField ver = PBField.initString("");
    public final PBStringField prompt = PBField.initString("");
    public QQGameSubscribe$ArkConfig config = new MessageMicro<QQGameSubscribe$ArkConfig>() { // from class: tencent.im.qqgame.QQGameSubscribe$ArkConfig
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"round", "type", "forward"}, new Object[]{0, "", 0}, QQGameSubscribe$ArkConfig.class);
        public final PBInt32Field round = PBField.initInt32(0);
        public final PBStringField type = PBField.initString("");
        public final PBInt32Field forward = PBField.initInt32(0);
    };
    public final PBStringField sourceName = PBField.initString("");
}
