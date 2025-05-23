package yt3;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.qqlive.superplayer.tools.utils.g;
import com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.superplayer.vinfo.TVKVideoInfo;
import com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfo;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import zt3.h;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e {
    private static void a(TVKCGIVideoInfo tVKCGIVideoInfo, TVKVideoInfo tVKVideoInfo) {
        if (tVKVideoInfo != null && tVKCGIVideoInfo != null) {
            for (int i3 = 0; i3 < tVKCGIVideoInfo.o().size(); i3++) {
                TVKCGIVideoInfo.TVKCGIVideoAudioTrackInfo tVKCGIVideoAudioTrackInfo = tVKCGIVideoInfo.o().get(i3);
                TVKNetVideoInfo.AudioTrackInfo audioTrackInfo = new TVKNetVideoInfo.AudioTrackInfo();
                audioTrackInfo.setAudioShowName(tVKCGIVideoAudioTrackInfo.g());
                audioTrackInfo.setAudioTrack(tVKCGIVideoAudioTrackInfo.l());
                audioTrackInfo.setKeyId(tVKCGIVideoAudioTrackInfo.e());
                audioTrackInfo.setAudioPrePlayTime(tVKCGIVideoAudioTrackInfo.j());
                audioTrackInfo.setAudioType(tVKCGIVideoAudioTrackInfo.c());
                int f16 = tVKCGIVideoAudioTrackInfo.f();
                if (f16 != 0) {
                    f16 = 1;
                }
                audioTrackInfo.setVip(f16);
                audioTrackInfo.setAudioUrlList(tVKCGIVideoAudioTrackInfo.m());
                audioTrackInfo.setAction(tVKCGIVideoAudioTrackInfo.b());
                if (tVKCGIVideoAudioTrackInfo.k() == 1) {
                    tVKVideoInfo.setCurAudioTrack(audioTrackInfo);
                }
                tVKVideoInfo.addAudioTrack(audioTrackInfo);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static TVKVideoInfo b(TVKVideoInfo tVKVideoInfo, TVKNetVideoInfo.DefnInfo defnInfo) {
        TVKNetVideoInfo.DefnInfo g16 = g(defnInfo);
        boolean z16 = true;
        boolean z17 = false;
        TVKNetVideoInfo.DefnInfo defnInfo2 = null;
        if (g16.getDefn().equalsIgnoreCase("hd") && tVKVideoInfo.getDefinitionList() != null) {
            Iterator<TVKNetVideoInfo.DefnInfo> it = tVKVideoInfo.getDefinitionList().iterator();
            while (it.hasNext()) {
                TVKNetVideoInfo.DefnInfo next = it.next();
                if (next.getDefn().compareToIgnoreCase("hd") == 0) {
                    if (g16.getDefnName().compareToIgnoreCase(com.tencent.qqlive.superplayer.tools.utils.a.a("hd")) != 0) {
                        z17 = true;
                        defnInfo2 = next;
                    } else {
                        z16 = false;
                    }
                    if (tVKVideoInfo.getDefinitionList() != null && z16 && defnInfo2 != null) {
                        com.tencent.qqlive.superplayer.tools.utils.d.d("VideoInfo[TVKVideoInfoTransfer.java]", "isNeedRemove");
                        tVKVideoInfo.getDefinitionList().remove(defnInfo2);
                    }
                    if (z17) {
                        tVKVideoInfo.addDefinition(g16);
                    }
                    return tVKVideoInfo;
                }
            }
        }
        z17 = true;
        z16 = false;
        if (tVKVideoInfo.getDefinitionList() != null) {
            com.tencent.qqlive.superplayer.tools.utils.d.d("VideoInfo[TVKVideoInfoTransfer.java]", "isNeedRemove");
            tVKVideoInfo.getDefinitionList().remove(defnInfo2);
        }
        if (z17) {
        }
        return tVKVideoInfo;
    }

    private static void c(TVKCGIVideoInfo tVKCGIVideoInfo, TVKVideoInfo tVKVideoInfo) {
        if (tVKVideoInfo != null && tVKCGIVideoInfo != null) {
            for (int i3 = 0; i3 < tVKCGIVideoInfo.m0().size(); i3++) {
                TVKCGIVideoInfo.TVKCGIVideoUrlInfo tVKCGIVideoUrlInfo = tVKCGIVideoInfo.m0().get(i3);
                TVKVideoInfo.ReferUrl referUrl = new TVKVideoInfo.ReferUrl();
                referUrl.setUrl(tVKCGIVideoUrlInfo.g());
                String g16 = tVKCGIVideoUrlInfo.g();
                Pattern compile = Pattern.compile("(?<=//|)((\\w)+\\.)+\\w+");
                if (g16 != null && !TextUtils.isEmpty(g16)) {
                    Matcher matcher = compile.matcher(g16);
                    if (matcher.find() && matcher.group() != null) {
                        tVKVideoInfo.addVideoDownloadHostItem(Integer.valueOf(i3), matcher.group());
                    }
                }
                referUrl.setVt(tVKCGIVideoUrlInfo.j());
                referUrl.setPath(tVKCGIVideoUrlInfo.b());
                referUrl.setSpip(tVKCGIVideoUrlInfo.e());
                TVKVideoInfo.HlsNode hlsNode = new TVKVideoInfo.HlsNode();
                hlsNode.setHk(tVKCGIVideoUrlInfo.a());
                hlsNode.setPt(tVKCGIVideoUrlInfo.c());
                referUrl.setHlsNode(hlsNode);
                tVKVideoInfo.addReferUrlItem(i3, referUrl);
            }
        }
    }

    private static void d(TVKCGIVideoInfo tVKCGIVideoInfo, TVKVideoInfo tVKVideoInfo) {
        if (tVKVideoInfo != null && tVKCGIVideoInfo != null) {
            for (int i3 = 0; i3 < tVKCGIVideoInfo.e0().size(); i3++) {
                TVKCGIVideoInfo.TVKCGIVideoSubtitleInfo tVKCGIVideoSubtitleInfo = tVKCGIVideoInfo.e0().get(i3);
                TVKNetVideoInfo.SubTitle subTitle = new TVKNetVideoInfo.SubTitle();
                subTitle.setmName(tVKCGIVideoSubtitleInfo.b());
                ArrayList arrayList = new ArrayList();
                arrayList.add(tVKCGIVideoSubtitleInfo.c());
                subTitle.setUrlList(arrayList);
                subTitle.setmKeyId(tVKCGIVideoSubtitleInfo.a());
                tVKVideoInfo.addSubTitle(subTitle);
            }
        }
    }

    public static String[] e(TVKVideoInfo tVKVideoInfo, h hVar) {
        Uri.Builder buildUpon;
        int size = tVKVideoInfo.getUrlList().size();
        String[] strArr = new String[size - 1];
        for (int i3 = 1; i3 < size; i3++) {
            String str = "";
            if (tVKVideoInfo.isHLSDownloadType()) {
                String url = tVKVideoInfo.getUrlList().get(i3).getUrl();
                if (!TextUtils.isEmpty(tt3.a.f437461b) && tt3.a.f437460a != null && com.tencent.qqlive.superplayer.tools.utils.h.m(tt3.a.c()) != 1) {
                    strArr[i3 - 1] = url;
                } else {
                    if (tVKVideoInfo.getUrlList().get(i3).getHlsNode() != null) {
                        url = url + tVKVideoInfo.getUrlList().get(i3).getHlsNode().getPt();
                    }
                    buildUpon = Uri.parse(url).buildUpon();
                    String hk5 = tVKVideoInfo.getUrlList().get(i3).getHlsNode().getHk();
                    if (!TextUtils.isEmpty(hk5) && !GlobalUtil.DEF_STRING.equals(hk5)) {
                        buildUpon.appendQueryParameter("hlskey", tVKVideoInfo.getUrlList().get(i3).getHlsNode().getHk());
                    } else {
                        buildUpon.appendQueryParameter("hlskey", "");
                    }
                }
            } else {
                buildUpon = Uri.parse(tVKVideoInfo.getUrlList().get(i3).getUrl() + tVKVideoInfo.getFileName()).buildUpon();
                buildUpon.appendQueryParameter("platform", String.valueOf(hVar.l()));
                buildUpon.appendQueryParameter(TtmlNode.TAG_BR, tVKVideoInfo.getBitrate());
                if (tVKVideoInfo.getCurDefinition() != null) {
                    str = tVKVideoInfo.getCurDefinition().getDefn();
                }
                buildUpon.appendQueryParameter(TPReportKeys.Common.COMMON_MEDIA_FORMAT, str);
                buildUpon.appendQueryParameter("vkey", tVKVideoInfo.getVKey());
                buildUpon.appendQueryParameter("level", tVKVideoInfo.getLevel());
                if (!TextUtils.isEmpty(tVKVideoInfo.getSha())) {
                    buildUpon.appendQueryParameter(WidgetCacheLunarData.SHA, tVKVideoInfo.getSha());
                }
            }
            buildUpon.appendQueryParameter("sdtfrom", hVar.o());
            buildUpon.appendQueryParameter("guid", tt3.a.e());
            strArr[i3 - 1] = buildUpon.toString();
        }
        return strArr;
    }

    private static void f(TVKVideoInfo tVKVideoInfo, h hVar) {
        String defn;
        if (tVKVideoInfo != null) {
            int size = tVKVideoInfo.getSectionList().size();
            String[] strArr = new String[size];
            for (int i3 = 0; i3 < size; i3++) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(tVKVideoInfo.getFirstCdnServer());
                sb5.append(tVKVideoInfo.getSectionList().get(i3).getIndexName());
                sb5.append("?&vkey=");
                sb5.append(tVKVideoInfo.getSectionList().get(i3).getVbkey());
                sb5.append("&platform=");
                sb5.append(hVar.l());
                sb5.append("&fmt=");
                if (tVKVideoInfo.getCurDefinition() == null) {
                    defn = "";
                } else {
                    defn = tVKVideoInfo.getCurDefinition().getDefn();
                }
                sb5.append(defn);
                sb5.append("&br=");
                sb5.append(String.valueOf(tVKVideoInfo.getBitrate()));
                sb5.append("&sdtfrom=");
                sb5.append(hVar.o());
                sb5.append("&guid=");
                sb5.append(tt3.a.e());
                sb5.append("&keyid=");
                sb5.append(tVKVideoInfo.getSectionList().get(i3).getVbkeyId());
                strArr[i3] = sb5.toString();
            }
            tVKVideoInfo.setClipUrl(strArr);
        }
    }

    private static TVKNetVideoInfo.DefnInfo g(TVKNetVideoInfo.DefnInfo defnInfo) {
        if (defnInfo == null) {
            return null;
        }
        if (defnInfo.getDefn().equalsIgnoreCase("mp4")) {
            defnInfo.setDefn("hd");
            defnInfo.setDefnName(com.tencent.qqlive.superplayer.tools.utils.a.a("hd"));
        }
        if (TextUtils.isEmpty(defnInfo.getDefnName())) {
            defnInfo.setDefnName(com.tencent.qqlive.superplayer.tools.utils.a.a(defnInfo.getDefn()));
        }
        return defnInfo;
    }

    private static void h(TVKCGIVideoInfo tVKCGIVideoInfo, TVKVideoInfo tVKVideoInfo) {
        if (tVKVideoInfo != null && tVKCGIVideoInfo != null) {
            if (vt3.d.K1.a().booleanValue()) {
                if (tVKVideoInfo.getExem() <= 0 && tVKVideoInfo.getSt() != 8) {
                    if (tVKVideoInfo.getSt() == 2) {
                        tVKVideoInfo.setPrePlayTime(tVKVideoInfo.getDuration());
                        return;
                    } else {
                        tVKVideoInfo.setPrePlayTime(tVKVideoInfo.getDuration());
                        return;
                    }
                }
                tVKVideoInfo.setPrePlayTime(tVKCGIVideoInfo.c0());
                return;
            }
            if (tVKVideoInfo.getSt() == 2) {
                tVKVideoInfo.setPrePlayTime(tVKVideoInfo.getDuration());
            } else if (tVKVideoInfo.getSt() != 8 && tVKVideoInfo.getExem() <= 0) {
                tVKVideoInfo.setPrePlayTime(tVKVideoInfo.getDuration());
            } else {
                tVKVideoInfo.setPrePlayTime(tVKCGIVideoInfo.c0());
            }
        }
    }

    public static TVKVideoInfo i(TVKCGIVideoInfo tVKCGIVideoInfo, h hVar) {
        TVKVideoInfo tVKVideoInfo = new TVKVideoInfo();
        if (tVKCGIVideoInfo == null) {
            return tVKVideoInfo;
        }
        tVKVideoInfo.setXml(tVKCGIVideoInfo.q0());
        com.tencent.qqlive.superplayer.tools.utils.d.d("VideoInfo[TVKVideoInfoTransfer.java]", "getvinfo=" + tVKCGIVideoInfo.q0());
        tVKVideoInfo.setTestId(tVKCGIVideoInfo.k0());
        tVKVideoInfo.setFp2p(tVKCGIVideoInfo.B());
        a(tVKCGIVideoInfo, tVKVideoInfo);
        int i3 = 0;
        for (int i16 = 0; i16 < tVKCGIVideoInfo.A().size(); i16++) {
            TVKCGIVideoInfo.TVKCGIVideoFormatInfo tVKCGIVideoFormatInfo = tVKCGIVideoInfo.A().get(i16);
            TVKNetVideoInfo.DefnInfo defnInfo = new TVKNetVideoInfo.DefnInfo();
            defnInfo.setDefn(tVKCGIVideoFormatInfo.l());
            int k3 = tVKCGIVideoFormatInfo.k();
            if (k3 != 0) {
                k3 = 1;
            }
            defnInfo.setVip(k3);
            defnInfo.setDefnId(tVKCGIVideoFormatInfo.j());
            defnInfo.setFileSize(tVKCGIVideoFormatInfo.f());
            defnInfo.setAudioCodec(tVKCGIVideoFormatInfo.a());
            defnInfo.setVideoCodec(tVKCGIVideoFormatInfo.p());
            defnInfo.setDrm(tVKCGIVideoFormatInfo.e());
            defnInfo.setHdr10EnHance(tVKCGIVideoFormatInfo.g());
            String c16 = tVKCGIVideoFormatInfo.c();
            if (!TextUtils.isEmpty(c16)) {
                defnInfo.setDefnShowName(g.a(c16));
            } else {
                defnInfo.setDefnShowName(com.tencent.qqlive.superplayer.tools.utils.a.a(tVKCGIVideoFormatInfo.l()));
            }
            defnInfo.setDefnRate(tVKCGIVideoFormatInfo.m());
            defnInfo.setDefnName(tVKCGIVideoFormatInfo.o());
            if (tVKCGIVideoFormatInfo.n() == 1) {
                tVKVideoInfo.setCurDefinition(defnInfo);
            }
            tVKVideoInfo = b(tVKVideoInfo, defnInfo);
        }
        d(tVKCGIVideoInfo, tVKVideoInfo);
        tVKVideoInfo.setDownloadType(tVKCGIVideoInfo.t());
        tVKVideoInfo.setSectionNum(tVKCGIVideoInfo.y());
        if (tVKCGIVideoInfo.y() > 0) {
            tVKVideoInfo.setDownloadType(4);
        }
        for (int i17 = 0; i17 < tVKCGIVideoInfo.Z().size(); i17++) {
            TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo tVKCGIVideoMp4ClipInfo = tVKCGIVideoInfo.Z().get(i17);
            TVKVideoInfo.Section section = new TVKVideoInfo.Section();
            section.setUrl(tVKCGIVideoMp4ClipInfo.g());
            section.setDuration(tVKCGIVideoMp4ClipInfo.b());
            section.setSize((int) tVKCGIVideoMp4ClipInfo.f());
            section.setVbkeyId(tVKCGIVideoMp4ClipInfo.e());
            section.setVbkey(tVKCGIVideoMp4ClipInfo.j());
            section.setIndexName(tVKCGIVideoInfo.z(), tVKCGIVideoMp4ClipInfo.c());
            section.setIdx(tVKCGIVideoMp4ClipInfo.c());
            tVKVideoInfo.addSectionItem(section);
        }
        tVKVideoInfo.setDanmuState(tVKCGIVideoInfo.u());
        tVKVideoInfo.setPayCh(tVKCGIVideoInfo.r());
        tVKVideoInfo.setSt(tVKCGIVideoInfo.d0());
        tVKVideoInfo.setDuration((int) tVKCGIVideoInfo.h0());
        tVKVideoInfo.setFileSize(tVKCGIVideoInfo.C());
        tVKVideoInfo.setTitle(tVKCGIVideoInfo.i0());
        tVKVideoInfo.setTargetId(String.valueOf(tVKCGIVideoInfo.g0()));
        tVKVideoInfo.setCkc(tVKCGIVideoInfo.s());
        tVKVideoInfo.setPLType(2);
        tVKVideoInfo.setPLString(tVKCGIVideoInfo.b0());
        tVKVideoInfo.setLnk(tVKCGIVideoInfo.V());
        tVKVideoInfo.setDrm(tVKCGIVideoInfo.v());
        tVKVideoInfo.setEnc(tVKCGIVideoInfo.w());
        if (tVKCGIVideoInfo.G() == 0) {
            tVKVideoInfo.setIsHevc(false);
        } else {
            tVKVideoInfo.setIsHevc(true);
        }
        tVKVideoInfo.setFileName(tVKCGIVideoInfo.z());
        tVKVideoInfo.setIFlag(tVKCGIVideoInfo.M());
        tVKVideoInfo.setEncryptionVideo(!TextUtils.isEmpty(tVKCGIVideoInfo.p()));
        tVKVideoInfo.setWidth(tVKCGIVideoInfo.t0());
        tVKVideoInfo.setHeight(tVKCGIVideoInfo.n0());
        tVKVideoInfo.setVid(tVKCGIVideoInfo.o0());
        tVKVideoInfo.setMediaVideoState(tVKCGIVideoInfo.a0());
        tVKVideoInfo.setWHRadio(tVKCGIVideoInfo.v0());
        tVKVideoInfo.setMediaVideoType(tVKCGIVideoInfo.r0());
        tVKVideoInfo.setStartPos(tVKCGIVideoInfo.F());
        tVKVideoInfo.setEndPos(tVKCGIVideoInfo.f0());
        tVKVideoInfo.setVideoType(tVKCGIVideoInfo.p0());
        tVKVideoInfo.setVst(tVKCGIVideoInfo.s0());
        tVKVideoInfo.setTie(tVKCGIVideoInfo.j0());
        tVKVideoInfo.setAdsid(tVKCGIVideoInfo.n());
        c(tVKCGIVideoInfo, tVKVideoInfo);
        tVKVideoInfo.setActionUrl(tVKCGIVideoInfo.l());
        tVKVideoInfo.setExem(tVKCGIVideoInfo.x());
        h(tVKCGIVideoInfo, tVKVideoInfo);
        tVKVideoInfo.setWanIP(tVKCGIVideoInfo.N());
        tVKVideoInfo.setVKey(tVKCGIVideoInfo.E());
        tVKVideoInfo.setBitrate(String.valueOf(tVKCGIVideoInfo.q()));
        try {
            if (!TextUtils.isEmpty(tVKCGIVideoInfo.m()) && tVKVideoInfo.getCurDefinition() != null && !TextUtils.isEmpty(tVKVideoInfo.getCurDefinition().getDefn()) && !tVKCGIVideoInfo.m().equalsIgnoreCase(tVKVideoInfo.getCurDefinition().getDefn())) {
                while (true) {
                    if (i3 >= tVKVideoInfo.getDefinitionList().size()) {
                        break;
                    }
                    TVKNetVideoInfo.DefnInfo defnInfo2 = tVKVideoInfo.getDefinitionList().get(i3);
                    if (defnInfo2.getDefn().equalsIgnoreCase(tVKCGIVideoInfo.m())) {
                        tVKVideoInfo.setCurDefinition(defnInfo2);
                        break;
                    }
                    i3++;
                }
            }
            tVKVideoInfo.setLocalVideo(tVKCGIVideoInfo.w0());
        } catch (Throwable th5) {
            com.tencent.qqlive.superplayer.tools.utils.d.d("VideoInfo[TVKVideoInfoTransfer.java]", "onPlayInfoSuccess catch error ==" + th5.getMessage());
        }
        String l06 = tVKCGIVideoInfo.l0();
        String[] e16 = e(tVKVideoInfo, hVar);
        tVKVideoInfo.setPlayUrl(l06);
        tVKVideoInfo.setBackPlayUrl(e16);
        if (tVKCGIVideoInfo.l0().contains("<?xml")) {
            f(tVKVideoInfo, hVar);
        }
        tVKVideoInfo.setCGIVideoInfo(tVKCGIVideoInfo);
        tVKVideoInfo.setWatermarkInfos(tVKCGIVideoInfo.u0());
        return tVKVideoInfo;
    }
}
