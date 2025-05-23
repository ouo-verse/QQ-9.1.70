package tencent.im.qqgame;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameFullScreenRemind$SsoShowRequest extends MessageMicro<QQGameFullScreenRemind$SsoShowRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{WadlProxyConsts.KEY_MATERIAL}, new Object[]{""}, QQGameFullScreenRemind$SsoShowRequest.class);
    public final PBStringField material = PBField.initString("");
}
