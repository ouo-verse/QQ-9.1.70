package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameCheckDownload$InstallTipRsp extends MessageMicro<QQGameCheckDownload$InstallTipRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"flag"}, new Object[]{0}, QQGameCheckDownload$InstallTipRsp.class);
    public final PBEnumField flag = PBField.initEnum(0);
}
